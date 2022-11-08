package config

import (
	"fmt"
	"gorm.io/gorm"
)

var DB *gorm.DB

type dbConfig struct {
	user     string
	password string
	host     string
	port     int
	dbName   string
}

func SetDbInfo() *dbConfig {
	connectInfo := dbConfig{
		user:     "t4er",
		password: "pay-oralng",
		host:     "localhost",
		port:     3307,
		dbName:   "pay",
	}
	return &connectInfo
}

func SetDb(dbConfig *dbConfig) string {
	return fmt.Sprintf(
		"%s:%s@tcp(%s:%d)/%s?charset=utf8mb4&parseTime=True&loc=Local",
		dbConfig.user,
		dbConfig.password,
		dbConfig.host,
		dbConfig.port,
		dbConfig.dbName,
	)
}
