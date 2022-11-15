package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

const restPort = ":8082"

var err error

func main() {
	//config.DB, err = gorm.Open(mysql.Open(config.SetDb(config.SetDbInfo())), &gorm.Config{})

	if err != nil {
		panic("DB 연결에 실패했습니다!")
	}

	r := gin.Default()
	r.GET("/ping", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{
			"message": "pong",
		})
	})

	r.Run(restPort)
}
