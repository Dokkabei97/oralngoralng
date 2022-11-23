package com.t4er.oralng.domain

import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Embeddable
class CommonEntity (

    @Column(name = "succeed_at")
    var succeedAt: ZonedDateTime?,

    @Enumerated(EnumType.STRING)
    @Column(name = "result_status")
    var resultStatus: ResultStatus,

    @Column(name = "result_message")
    var resultMessage: String,
) {

    enum class ResultStatus(val description: String) {
        SUCCESS("성공"),
        FAIL("실패"),
    }

    companion object {
        fun of(succeedAt: ZonedDateTime?, resultStatus: ResultStatus, resultMessage: String): CommonEntity {
            return CommonEntity(succeedAt, resultStatus, resultMessage)
        }
    }
}