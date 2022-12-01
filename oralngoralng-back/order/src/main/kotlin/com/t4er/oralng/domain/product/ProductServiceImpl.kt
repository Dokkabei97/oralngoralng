package com.t4er.oralng.domain.product

import com.t4er.oralng.domain.product.ProductCommand.RegisterProductRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ProductServiceImpl(
    val productStore: ProductStore,
    val productReader: ProductReader
) : ProductService {

    @Transactional
    override fun registerProduct(command: RegisterProductRequest): ProductInfo {
        val product = productStore.store(
            Product.of(
                command.name,
                command.price,
                command.duration,
                command.membershipName,
            )
        )
        return ProductInfo(product)
    }

    override fun getProducts(): List<ProductInfo> {
        val products = productReader.getProducts()
        return products.map { ProductInfo(it) }.toList()
    }
}