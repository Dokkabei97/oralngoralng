package domain

import (
	"log"
	"pay/config"
)

type PayService interface {
	GetPay(payId int, userId int)
	GetPays(userId int) ([]Pay, error)
	GetAllPays([]Pay, error)
}

func (pay *Pay) GetPay(payId int, userId int) {
	result := config.DB.Where(&Pay{
		PayId:  payId,
		UserId: userId,
	}).Find(pay)

	if result.Error != nil {
		log.Println(result.Error)
	}
}

func (pay *Pay) GetPays(userId int) ([]Pay, error) {
	//TODO implement me
	panic("implement me")
}

func (pay *Pay) GetAllPays(pays []Pay, err error) {
	//TODO implement me
	panic("implement me")
}
