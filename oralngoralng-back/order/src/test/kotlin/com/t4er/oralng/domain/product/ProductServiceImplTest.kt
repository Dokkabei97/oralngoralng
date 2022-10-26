package com.t4er.oralng.domain.product

import com.t4er.oralng.domain.product.ProductCommand.*
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

internal class ProductServiceImplTest : BehaviorSpec({
    val productService = mockk<ProductService>(relaxed = true)

    given("Product 서비스") {
        val registerProductRequest = mockk<RegisterProductRequest>()
        val productInfo = mockk<ProductInfo>()
        `when`("registerProduct 호출") {
            every { productService.registerProduct(any()) } returns productInfo
            productService.registerProduct(registerProductRequest)
            then("registerProduct 호출") {
                verify { productService.registerProduct(any()) }
            }
        }
    }
})
