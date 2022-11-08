package entity

import "gorm.io/gorm"

type PayMethod int

const (
	CARD PayMethod = iota + 1
	NAVER_PAY
	KAKAO_PAY
	TOSS_PAY
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
