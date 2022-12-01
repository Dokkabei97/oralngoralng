package com.t4er.oralng.util

import org.springframework.stereotype.Component

@Component
class JwtTokenProvider {

    companion object {
        private const val ACCESS_TOKEN_EXPIRE_TIME: Long = 1000L * 60 * 60 * 24;
        private const val REFRESH_TOKEN_EXPIRE_TIME: Long = 1000L * 60 * 60 * 24 * 30
    }
}