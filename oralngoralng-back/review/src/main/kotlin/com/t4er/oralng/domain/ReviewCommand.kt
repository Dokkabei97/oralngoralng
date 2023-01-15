package com.t4er.oralng.domain

import com.t4er.oralng.domain.tag.Location
import com.t4er.oralng.domain.tag.Theme
import jakarta.validation.constraints.NotBlank

class ReviewCommand {

    class CreateReviewRequest(
        val userId: Long,
        @field: NotBlank(message = "title은 필수 입니다.")
        val title: String,
        @field: NotBlank(message = "content은 필수 입니다.")
        val content: String,
        val locationTags: MutableList<Location>,
        val themeTags: MutableList<Theme>
    )

    class UpdateReviewRequest(
        val reviewId: Long,
        val userId: Long,
        @field: NotBlank(message = "title은 필수 입니다.")
        val title: String,
        @field: NotBlank(message = "content은 필수 입니다.")
        val content: String,
        val locationTags: MutableList<Location>,
        val themeTags: MutableList<Theme>
    )
}