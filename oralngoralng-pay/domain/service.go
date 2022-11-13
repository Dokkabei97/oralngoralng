package domain

import (
	"log"
	"pay/common"
	"pay/config"
)

type PayService interface {
	RegisterPay() (*Pay, error)
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
