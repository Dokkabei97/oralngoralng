package com.t4er.oralng.domain.product

interface ProductReader {
    fun getProducts(): List<Product>
}