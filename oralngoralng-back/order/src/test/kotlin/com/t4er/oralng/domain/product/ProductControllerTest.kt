package com.t4er.oralng.domain.product

import com.fasterxml.jackson.databind.ObjectMapper
import com.t4er.oralng.domain.product.ProductCommand.RegisterProductRequest
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.nio.charset.StandardCharsets

@SpringBootTest
@AutoConfigureMockMvc
internal class ProductControllerTest(
        @Autowired val mockMvc: MockMvc,
        @Autowired val objectMapper: ObjectMapper
) : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    companion object {
        const val URI = "/api/v1/products"
    }

    init {
        describe("상품 컨트롤러") {
            context("신규 상품 추가 API") {
                val dto = RegisterProductRequest(
                        "알뜰 상품",
                        20000,
                        "3Month",
                        Product.MembershipName.BASIC
                )
                val requestBuilder = MockMvcRequestBuilders.post(URI)
                        .content(objectMapper.writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8.displayName())
                it("상품 추가 성공") {
                    mockMvc.perform(requestBuilder)
                            .andExpect(MockMvcResultMatchers.status().isOk)
                            .andExpect(MockMvcResultMatchers.jsonPath("\$.data.name").value("알뜰 상품"))
                            .andExpect(MockMvcResultMatchers.jsonPath("\$.data.price").value(20000))
                }
            }
        }
    }
}
