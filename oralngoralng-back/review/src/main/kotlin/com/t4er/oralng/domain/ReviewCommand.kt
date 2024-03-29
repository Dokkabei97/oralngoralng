package com.t4er.oralng.domain

import com.t4er.oralng.domain.tag.Location
import com.t4er.oralng.domain.tag.Theme
import jakarta.validation.constraints.NotBlank

class ReviewCommand {

    class CreateReviewRequest(
        val userId: Long,
        @field: NotBlank(message = "nickname 입니다.")
        val nickname: String,
        @field: NotBlank(message = "title은 필수 입니다.")
        val title: String,
        @field: NotBlank(message = "content은 필수 입니다.")
        val content: String,
        val images: MutableList<ImageRequest>,
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
        val images: MutableList<ImageRequest>,
        val locationTags: MutableList<Location>,
        val themeTags: MutableList<Theme>
    )

    data class ImageRequest(
        @field: NotBlank(message = "url은 필수 입니다.")
        val url: String,
        @field: NotBlank(message = "description은 필수 입니다.")
        val description: String
    )

    class DeleteReviewRequest(
        val reviewId: Long,
        val userId: Long
    )
}