package com.t4er.oralng.infrastructure.product

import com.t4er.oralng.domain.product.Product
import com.t4er.oralng.domain.product.ProductReader
import org.springframework.stereotype.Component

@Component
class ProductReaderImpl(val productRepository: ProductRepository): ProductReader {

    override fun getProducts(): List<Product> {
        return productRepository.findAll()
    }
}