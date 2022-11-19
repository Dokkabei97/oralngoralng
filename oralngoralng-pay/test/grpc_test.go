package test

import (
	"context"
	"google.golang.org/grpc"
	"log"
	"pay/proto"
	"testing"
	"time"
)

const grpcAddress = "localhost:9000"

func TestGrpcTest(t *testing.T) {
	conn, err := grpc.Dial(grpcAddress, grpc.WithInsecure())
	if err != nil {
		log.Println(err)
	}
	defer conn.Close()
	ctx, cancel := context.WithTimeout(context.Background(), time.Second*5)
	client := proto.NewPayServiceClient(conn)
	defer cancel()

	pay := proto.PaymentRequest{
		OrderToken: "ord_test",
		UserId:     1,
		ProductId:  1,
		Price:      5000,
		PayMethod:  proto.PayMethod_NAVER_PAY,
	}

	res, err := client.RegisterPayRequest(ctx, &pay)
	if res != nil {
		log.Println(res)
	}
}
