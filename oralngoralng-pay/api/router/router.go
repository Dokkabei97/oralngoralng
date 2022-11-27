package router

import (
	"github.com/gin-gonic/gin"
	"net/http"
	"pay/api/domain"
	"strconv"
)

const API = "/api/v1"

func SetRouter() *gin.Engine {
	router := gin.Default()

	payRouter := router.Group(API + "/pays")
	{
		pay := domain.Pay{}
		var payService domain.PayService
		payService = &pay

		payRouter.GET("", func(context *gin.Context) {
			payId := context.Query("payId")
			userId := context.Query("userId")

			parseIntPayId, err := strconv.Atoi(payId)
			if err != nil {
				context.JSON(http.StatusOK, gin.H{
					"error": err,
				})
			}
			parseIntUserId, err := strconv.Atoi(userId)
			if err != nil {
				context.JSON(http.StatusOK, gin.H{
					"error": err,
				})
			}

			payService.GetPay(parseIntPayId, parseIntUserId)
			if err != nil {
				context.JSON(http.StatusOK, gin.H{
					"error": err,
				})
			} else {
				context.JSON(http.StatusOK, gin.H{
					"pays": pay,
				})
			}
		})

		payRouter.GET("/graphql", func(context *gin.Context) {

		})
	}

	return router
}
