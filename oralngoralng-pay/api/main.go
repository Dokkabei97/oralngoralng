package main

import (
	"gorm.io/driver/mysql"
	"gorm.io/gorm"
	"log"
	"pay/api/router"
	"pay/config"
)

const port = ":8082"

var err error

func main() {
	config.DB, err = gorm.Open(mysql.Open(config.SetDb(config.SetDbInfo())), &gorm.Config{})

	if err != nil {
		panic("DB 연결에 실패했습니다!")
	}

	r := router.SetRouter()
	err = r.Run(port)
	if err != nil {
		log.Println(err)
	}
}
