package main

import (
	"context"
	"google.golang.org/grpc"
	"gorm.io/driver/mysql"
	"gorm.io/gorm"
	"log"
	"net"
	"pay/api/domain"
	"pay/common"
	"pay/config"
	"pay/proto"
)

const port = ":8090"

var err error

type server struct {
	proto.PayServiceServer
}

func (s *server) RegisterPayRequest(ctx context.Context, request *proto.PaymentRequest) (*proto.PaymentResponse, error) {
	var payMethod domain.PayMethod
	switch request.PayMethod {
	case 0:
		payMethod = "CARD"
	case 1:
		payMethod = "NAVER_PAY"
	case 2:
		payMethod = "TOSS_PAY"
	case 3:
		payMethod = "KAKAO_PAY"
	}

	pay := domain.Pay{
		OrderToken: request.OrderToken,
		UserId:     int(request.UserId),
		ProductId:  int(request.ProductId),
		Price:      int(request.Price),
		PayMethod:  payMethod,
	}
	generatorBillingKey(&pay)
	if err = config.DB.Create(&pay).Error; err != nil {
		log.Println(err)
	}
	return nil, err
}

func generatorBillingKey(pay *domain.Pay) *domain.Pay {
	var prefix string
	switch pay.PayMethod {
	case domain.Card:
		prefix = "CP"
	case domain.NaverPay:
		prefix = "NP"
	case domain.KakaoPay:
		prefix = "KP"
	case domain.TossPay:
		prefix = "TP"
	}
	pay.BillingKey = common.RandomCharacterWithPrefix(prefix)
	return pay
}

func main() {
	config.DB, err = gorm.Open(mysql.Open(config.SetDb(config.SetDbInfo())), &gorm.Config{})
	if err != nil {
		panic("DB 연결에 실패했습니다!")
	}

	listen, err := net.Listen("tcp", port)
	if err != nil {
		log.Println(err)
	}
	s := grpc.NewServer()
	proto.RegisterPayServiceServer(s, &server{})

	if err := s.Serve(listen); err != nil {
		log.Println(err)
	}
}
