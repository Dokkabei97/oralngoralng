package com.t4er.oralng.domain.product

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ProductServiceImpl(val productStore: ProductStore, val productReader: ProductReader): ProductService {


}