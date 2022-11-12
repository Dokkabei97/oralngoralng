package domain

import (
	"gorm.io/gorm"
	"pay/common"
)

type PayMethod string

const (
	Card     PayMethod = "CARD"
	NaverPay           = "NAVER_PAY"
	KakaoPay           = "KAKAO_PAY"
	TossPay            = "TOSS_PAY"
)

type Pay struct {
	gorm.Model
	OrderToken string    `gorm:"not null"`
	UserId     int       `gorm:"not null"`
	ProductId  int       `gorm:"not null"`
	Price      int       `gorm:"not null"`
	PayMethod  PayMethod `gorm:"not null"`
	BillingKey string    `gorm:"not null"`
}

func RegisterPay(pay *Pay) error {
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

	return nil
}
