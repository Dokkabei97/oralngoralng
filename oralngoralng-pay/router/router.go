package router

import (
	"github.com/gin-gonic/gin"
	"log"
	"net/http"
	"pay/domain"
	"strconv"
)

const API = "/api/v1"

func SetRouter() *gin.Engine {
	pay := domain.Pay{}
	var payService domain.PayService
	payService = &pay

	router := gin.Default()

	payRouter := router.Group(API + "/pays")
	{
		payRouter.GET("", func(context *gin.Context) {

		})

		payRouter.GET("", func(context *gin.Context) {
			userId := context.Query("userId")
			a, _ := strconv.Atoi(userId)
			pays, err := payService.GetPays(a)
			if err != nil {
				return
			}
			context.JSON(http.StatusOK, gin.H{
				"pays": pays,
			})
		})

		payRouter.GET("", func(context *gin.Context) {

		})

		payRouter.POST("", func(context *gin.Context) {
			registerPay, err := payService.RegisterPay()
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
