package domain

import "time"

type PayMethod string

const (
	Card     PayMethod = "CARD"
	NaverPay           = "NAVER_PAY"
	KakaoPay           = "KAKAO_PAY"
	TossPay            = "TOSS_PAY"
)

type Pay struct {
	PayId      int       `json:"payId" gorm:"primaryKey"`
	OrderToken string    `json:"orderToken" gorm:"not null"`
	UserId     int       `json:"userId" gorm:"not null"`
	ProductId  int       `json:"productId"gorm:"not null"`
	Price      int       `json:"price" gorm:"not null"`
	PayMethod  PayMethod `json:"payMethod" gorm:"not null"`
	BillingKey string    `json:"billingKey" gorm:"not null"`
	CreatedAt  time.Time `json:"createdAt" gorm:"not null"`
	UpdatedAt  time.Time `json:"updatedAt" gorm:"not null"`
}
