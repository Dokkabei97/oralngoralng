package com.t4er.oralng.`interface`.product

import com.t4er.oralng.application.product.ProductFacade
import org.springframework.stereotype.Controller

@Controller
class ProductController(val productFacade: ProductFacade) {
}