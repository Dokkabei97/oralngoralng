package com.t4er.oralng.application.product

import com.t4er.oralng.domain.product.ProductCommand
import com.t4er.oralng.domain.product.ProductCommand.*
import com.t4er.oralng.domain.product.ProductInfo
import com.t4er.oralng.domain.product.ProductService
import org.springframework.stereotype.Service

@Service
class ProductFacade(val productService: ProductService) {

    fun registerProduct(command: RegisterProductRequest): ProductInfo = productService.registerProduct(command)
    fun getProducts(): List<ProductInfo> = productService.getProducts()

}