package test

import (
	"fmt"
	"pay/api/domain"
	"pay/common"
	"testing"
)

type TestPay struct {
	OrderToken string
	UserId     int
	ProductId  int
	Price      int
	PayMethod  domain.PayMethod
	BillingKey string
}

func TestGeneratorBillingKey(t *testing.T) {

	pay := TestPay{
		"ord_testToken",
		1,
		1,
		5000,
		domain.NaverPay,
		"",
	}

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

	billingKey := common.RandomCharacterWithPrefix(prefix)
	pay.BillingKey = billingKey
	fmt.Println(pay)
}
