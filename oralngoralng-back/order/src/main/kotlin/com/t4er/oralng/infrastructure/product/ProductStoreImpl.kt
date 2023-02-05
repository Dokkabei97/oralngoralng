package com.t4er.oralng.infrastructure.product

import com.t4er.oralng.domain.product.Product
import com.t4er.oralng.domain.product.ProductStore
import org.springframework.stereotype.Component

@Component
class ProductStoreImpl(val productRepository: ProductRepository) : ProductStore {

    override fun store(product: Product): Product = productRepository.save(product)

}