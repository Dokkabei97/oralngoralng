package com.t4er.oralng.`interface`.product

import com.t4er.oralng.application.product.ProductFacade
import com.t4er.oralng.domain.product.ProductCommand
import com.t4er.oralng.domain.product.ProductCommand.*
import com.t4er.oralng.domain.product.ProductInfo
import com.t4er.oralng.response.CommonHttpResponse
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/products")
class ProductController(val productFacade: ProductFacade) {

    @PostMapping
    fun registerProduct(@RequestBody @Valid input: RegisterProductRequest): CommonHttpResponse<ProductInfo> {
        val product = productFacade.registerProduct(input)
        return CommonHttpResponse.success(product)
    }

    @GetMapping
    fun getProducts(): CommonHttpResponse<List<ProductInfo>> {
        val products = productFacade.getProducts()
        return CommonHttpResponse.success(products)
    }
}