package com.t4er.oralng.config

import org.springframework.kafka.core.KafkaTemplate

class KafkaConfig(val template: KafkaTemplate<Int, String>) {

    fun send() = template.send(TOPIC_NAME, "kafka test")

    companion object {
        const val TOPIC_NAME = "review"
    }
}