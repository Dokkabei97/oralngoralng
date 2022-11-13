package common

import (
	"crypto/rand"
	"encoding/hex"
)

const tokenLength int = 12

func randomCharacter(length int) string {
	b := make([]byte, length)
	rand.Read(b)
	return hex.EncodeToString(b)
}

func RandomCharacterWithPrefix(prefix string) string {
	return prefix + randomCharacter(tokenLength-len([]rune(prefix)))
}
