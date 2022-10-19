package com.t4er.oralng.domain.product

import com.t4er.oralng.domain.product.ProductCommand.*

interface ProductService {
    fun registerProduct(command: RegisterProductRequest): ProductInfo
}