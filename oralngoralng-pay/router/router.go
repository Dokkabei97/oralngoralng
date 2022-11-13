package router

import (
	"github.com/gin-gonic/gin"
	"log"
	"net/http"
	"pay/domain"
)

const API = "/api/v1"

func SetRouter() *gin.Engine {
	router := gin.Default()

	pay := router.Group(API + "/pays")
	{
		pay.GET("", func(context *gin.Context) {

		})

		pay.GET("/graphql", func(context *gin.Context) {

		})

		pay.POST("", func(context *gin.Context) {
			pay := domain.Pay{}
			//todo pay
			registerPay, err := domain.PayService.RegisterPay(&pay)
			if err != nil {
				log.Println(err)
			}
			context.JSON(http.StatusOK, gin.H{
				"message": registerPay,
			})
		})
	}

	return router
}
