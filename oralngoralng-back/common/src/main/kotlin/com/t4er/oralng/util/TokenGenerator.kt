package com.t4er.oralng.util

import org.apache.commons.lang3.RandomStringUtils

class TokenGenerator {
    companion object {
        private const val TOKEN_LENGTH: Int = 20

        fun randomCharacter(length: Int): String {
            return RandomStringUtils.randomAlphanumeric(length)
        }

        fun randomCharacterWithPrefix(prefix: String): String {
            return prefix + randomCharacter(TOKEN_LENGTH - prefix.length)
        }
    }
}