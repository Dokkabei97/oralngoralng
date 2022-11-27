package com.t4er.oralng.`interface`.product

import com.t4er.oralng.application.product.ProductFacade
import com.t4er.oralng.domain.product.ProductCommand.*
import com.t4er.oralng.domain.product.ProductInfo
import com.t4er.oralng.response.CommonHttpResponse
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid

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