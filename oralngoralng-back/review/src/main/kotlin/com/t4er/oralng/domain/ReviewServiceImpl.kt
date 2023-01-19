package com.t4er.oralng.domain

import com.t4er.oralng.domain.ReviewCommand.*
import com.t4er.oralng.domain.tag.Location
import com.t4er.oralng.domain.tag.Theme
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ReviewServiceImpl(val reviewReader: ReviewReader, val reviewStore: ReviewStore) : ReviewService {

    override fun create(review: CreateReviewRequest) {
        val locations: String = locationListToString(review.locationTags)
        val themes: String = themeListToString(review.themeTags)
        val images: MutableMap<Int, String> = imageListToMap(review.images)
        val of: Review = Review.of(
            review.userId,
            review.nickname,
            review.title,
            review.content,
            images,
            locations,
            themes
        )
        reviewStore.create(of)
    }

    override fun update(review: UpdateReviewRequest) {
        val findById: Review = reviewReader.getReview(review.reviewId)
        val locations: String = locationListToString(review.locationTags)
        val themes: String = themeListToString(review.themeTags)
        val images: MutableMap<Int, String> = imageListToMap(review.images)
        findById.update(review.title, review.content, images, locations, themes)
    }

    override fun delete(review: DeleteReviewRequest) {
        reviewStore.delete(review.reviewId)
    }

    private fun imageListToMap(list: List<String>): MutableMap<Int, String> {
        val images: MutableMap<Int, String> = HashMap()
        list.withIndex().forEach { (index, image) ->
            images[index] = image
        }
        return images
    }

    private fun themeListToString(list: MutableList<Theme>): String {
        var themes: String = ""
        list.forEach { theme ->
            themes += theme.description + ", "
        }
        return themes.substring(0, themes.length - 2)
    }

    private fun locationListToString(list: MutableList<Location>): String {
        var locations: String = ""
        list.forEach { location ->
            locations += location.description + ", "
        }
        return locations.substring(0, locations.length - 2)
    }
}