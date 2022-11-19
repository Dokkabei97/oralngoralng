package domain

type PayService interface {
	GetPay(payId int, userId int) (Pay, error)
	GetPays(userId int) ([]Pay, error)
	GetAllPays([]Pay, error)
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
