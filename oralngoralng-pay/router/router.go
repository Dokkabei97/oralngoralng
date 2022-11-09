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
		pay.POST("", func(context *gin.Context) {
			context.JSON(http.StatusOK, gin.H{
				"message": "test",
			})
		})
	}

	return router
}
