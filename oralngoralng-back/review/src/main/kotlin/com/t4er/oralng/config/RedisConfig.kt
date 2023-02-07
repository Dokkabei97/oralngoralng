package com.t4er.oralng.config

import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisSentinelConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

class RedisConfig {

    @Bean
    fun lettuceConnectionFactory(): RedisConnectionFactory {
        val sentinelConfig: RedisSentinelConfiguration = RedisSentinelConfiguration()
            .master("master")
            .sentinel("127.0.0.1", 26379)
            .sentinel("127.0.0.1", 26380)
        return LettuceConnectionFactory(sentinelConfig)
    }
}