package com.t4er.oralng.domain.order

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.time.ZoneId
import java.time.ZonedDateTime

internal class OrderTest : DescribeSpec({

    describe("주문") {
        var now: ZonedDateTime = ZonedDateTime.now()
        var expirateAt: ZonedDateTime
        context("만료일 검증") {
            expirateAt = now.plusMonths(3)
                .withHour(12)
                .withMinute(0)
                .withSecond(0)
                .withNano(0)
            it("성공") {
                expirateAt shouldBe ZonedDateTime.of(now.year, now.monthValue.plus(3), now.dayOfMonth, 12, 0, 0, 0, ZoneId.of("Asia/Seoul"))
            }
        }
    }
})
