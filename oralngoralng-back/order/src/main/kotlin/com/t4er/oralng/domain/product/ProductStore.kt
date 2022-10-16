package com.t4er.oralng.domain.product

interface ProductStore {
    fun store(product: Product): Product
}