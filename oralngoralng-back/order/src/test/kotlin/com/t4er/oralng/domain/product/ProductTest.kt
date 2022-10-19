package com.t4er.oralng.domain.product

import com.t4er.oralng.domain.membership.Membership
import com.t4er.oralng.domain.membership.Membership.*
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ProductTest : DescribeSpec({

    describe("product") {
        val product = Product.of(MembershipName.BASIC, "", 5000, "")
        context("") {

            it("") {

            }
        }
    }

})
