package router

import (
	"github.com/gin-gonic/gin"
	"net/http"
	"pay/api/domain"
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

		payRouter.GET("/graphql", func(context *gin.Context) {

		})
	}

	return router
}
