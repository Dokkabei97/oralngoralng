package domain

import (
	"fmt"
	"pay/common"
	"testing"
)

type TestPay struct {
	OrderToken string
	UserId     int
	ProductId  int
	Price      int
	PayMethod  PayMethod
	BillingKey string
}

func TestGeneratorBillingKey(t *testing.T) {

	pay := TestPay{
		"ord_testToken",
		1,
		1,
		5000,
		NaverPay,
		"",
	}

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

	billingKey := common.RandomCharacterWithPrefix(prefix)
	pay.BillingKey = billingKey
	fmt.Println(pay)
}
