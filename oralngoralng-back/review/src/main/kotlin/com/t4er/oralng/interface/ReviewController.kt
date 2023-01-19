package com.t4er.oralng.`interface`

import com.t4er.oralng.application.ReviewFacade
import org.springframework.stereotype.Controller

@Controller
class ReviewController(val reviewFacade: ReviewFacade) {
}