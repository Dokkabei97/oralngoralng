package com.t4er.oralng.domain.product

import jakarta.validation.constraints.NotBlank


class ProductCommand {

    class RegisterProductRequest(
        @field: NotBlank(message = "name 은 필수 입니다.")
        val name: String,
        val price: Int,
        @field: NotBlank(message = "duration 은 필수 입니다.")
        val duration: String,
        val membershipName: Product.MembershipName,
    )
}