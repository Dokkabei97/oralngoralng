package com.t4er.oralng.common.utils

import org.apache.commons.lang3.RandomStringUtils

open class TokenGenerator {

    companion object {
        const val TOKEN_LENGTH: Int = 20

        private fun randomCharacter(length: Int): String {
            return RandomStringUtils.randomAlphanumeric(length)
        }

        fun randomCharacterWithPrefix(prefix: String): String {
            return prefix + randomCharacter(TOKEN_LENGTH - prefix.length)
        }
    }

}