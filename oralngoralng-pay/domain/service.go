package domain

import (
	"log"
	"pay/common"
	"pay/config"
)

type PayService interface {
	RegisterPay() (*Pay, error)
	GetPay(payId int, userId int) (Pay, error)
	GetPays(userId int) ([]Pay, error)
	GetAllPays([]Pay, error)
}

func (pay *Pay) RegisterPay() (*Pay, error) {
	var prefix string
	switch pay.PayMethod {
	case Card:
		prefix = "CP"
	case NaverPay:
		prefix = "NP"
	case KakaoPay:
		prefix = "KP"
	case TossPay:
		prefix = "TP"
	}
	pay.BillingKey = common.RandomCharacterWithPrefix(prefix)

	err := config.DB.Create(pay).Error
	if err != nil {
		log.Println(err)
	}
	return pay, err
}

func (pay *Pay) GetPay(payId int, userId int) (Pay, error) {
	//TODO implement me
	panic("implement me")
}

func (pay *Pay) GetPays(userId int) ([]Pay, error) {
	//TODO implement me
	panic("implement me")
}

func (pay *Pay) GetAllPays(pays []Pay, err error) {
	//TODO implement me
	panic("implement me")
}
