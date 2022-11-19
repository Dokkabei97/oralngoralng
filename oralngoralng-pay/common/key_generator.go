package common

import (
	"crypto/rand"
	"encoding/hex"
	"log"
)

const tokenLength int = 12

func randomCharacter(length int) string {
	b := make([]byte, length)
	_, err := rand.Read(b)
	if err != nil {
		log.Println(err)
	}
	return hex.EncodeToString(b)
}

func RandomCharacterWithPrefix(prefix string) string {
	return prefix + randomCharacter(tokenLength-len([]rune(prefix)))
}
