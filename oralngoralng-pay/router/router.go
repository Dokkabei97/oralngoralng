package router

import (
	"github.com/gin-gonic/gin"
	"net/http"
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
			context.JSON(http.StatusOK, gin.H{
				"message": "test",
			})
		})
	}

	return router
}
