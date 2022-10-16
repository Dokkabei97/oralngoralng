package com.t4er.oralng.infrastructure.product

import com.t4er.oralng.domain.product.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {

}