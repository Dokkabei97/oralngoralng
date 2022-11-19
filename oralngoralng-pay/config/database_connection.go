package config

import (
	"fmt"
	"gorm.io/gorm"
)

var DB *gorm.DB

type DbConfig struct {
	user     string
	password string
	host     string
	port     int
	dbName   string
}

func SetDbInfo() *DbConfig {
	connectInfo := DbConfig{
		user:     "pay-t4er",
		password: "pay-oralng",
		host:     "localhost",
		port:     3307,
		dbName:   "pay",
	}
	return &connectInfo
}

func SetDb(dbConfig *DbConfig) string {
	return fmt.Sprintf(
		"%s:%s@tcp(%s:%d)/%s?charset=utf8mb4&parseTime=True&loc=Local",
		dbConfig.user,
		dbConfig.password,
		dbConfig.host,
		dbConfig.port,
		dbConfig.dbName,
	)
}
