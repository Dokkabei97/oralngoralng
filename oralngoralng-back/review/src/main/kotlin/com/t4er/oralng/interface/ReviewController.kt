package com.t4er.oralng.`interface`

import com.t4er.oralng.application.ReviewFacade
import com.t4er.oralng.domain.ReviewCommand.CreateReviewRequest
import com.t4er.oralng.domain.ReviewCommand.UpdateReviewRequest
import com.t4er.oralng.domain.ReviewInfo
import jakarta.validation.Valid
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class ReviewController(val reviewFacade: ReviewFacade) {

    @MutationMapping
    fun createReview(@Argument @Valid input: CreateReviewRequest): ReviewInfo = reviewFacade.createReview(input)

    @MutationMapping
    fun updateReview(@Argument @Valid input: UpdateReviewRequest): ReviewInfo = reviewFacade.updateReview(input)

}