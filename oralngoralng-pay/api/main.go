package main

import (
	"log"
	"pay/api/router"
)

const restPort = ":8082"

var err error

func main() {
	//config.DB, err = gorm.Open(mysql.Open(config.SetDb(config.SetDbInfo())), &gorm.Config{})

	if err != nil {
		panic("DB 연결에 실패했습니다!")
	}

	r := router.SetRouter()
	err = r.Run(restPort)
	if err != nil {
		log.Println(err)
	}
}
