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
        val of: Review = Review.of(review.userId, review.title, review.content, locations, themes)
        reviewStore.create(of)
    }

    override fun update(review: UpdateReviewRequest) {
        val findById: Review = reviewReader.getReview(review.reviewId)
        val locations: String = locationListToString(review.locationTags)
        val themes: String = themeListToString(review.themeTags)
        findById.update(review.title, review.content, locations, themes)
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