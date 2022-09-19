package com.t4er.oralng.domain

import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class CommonEntity (

    @Column(name = "successed_at")
    var successedAt: ZonedDateTime?,

    @Column(name = "result_status")
    var resultStatus: String?,

    @Column(name = "result_message")
    var resultMessage: String?,
) {
    companion object {
        fun of(successedAt: ZonedDateTime?, resultStatus: String?, resultMessage: String?): CommonEntity {
            return CommonEntity(successedAt, resultStatus, resultMessage)
        }
    }
}