package com.t4er.oralng.domain

import com.t4er.oralng.domain.ReviewCommand.*
import com.t4er.oralng.domain.tag.Location
import com.t4er.oralng.domain.tag.Theme
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ReviewServiceImpl(val reviewReader: ReviewReader, val reviewStore: ReviewStore) : ReviewService {

    @Transactional
    override fun create(command: CreateReviewRequest): ReviewInfo {
        val locations: String = locationListToString(command.locationTags)
        val themes: String = themeListToString(command.themeTags)
        val images: List<Image> = requestToImage(command.images)
        val review: Review = Review.of(
            command.userId,
            command.nickname,
            command.title,
            command.content,
            images,
            locations,
            themes
        )
        val of = reviewStore.create(review)
        return ReviewInfo(of)
    }

    @Transactional
    override fun update(command: UpdateReviewRequest): ReviewInfo {
        val review: Review = reviewReader.getReview(command.reviewId)
        val locations: String = locationListToString(command.locationTags)
        val themes: String = themeListToString(command.themeTags)
        val images: List<Image> = requestToImage(command.images)
        review.update(command.title, command.content, images, locations, themes)
        return ReviewInfo(review)
    }

    @Transactional
    override fun delete(command: DeleteReviewRequest) {
        reviewStore.delete(command.reviewId)
    }

    private fun requestToImage(list: MutableList<ImageRequest>): List<Image> {
        return list.stream()
            .map { Image(it.url, it.description) }
            .toList()
    }

    private fun themeListToString(list: MutableList<Theme>): String {
        var themes: String = ""
        list.forEach {
            themes += it.description + ", "
        }
        return themes.substring(0, themes.length - 2)
    }

    private fun locationListToString(list: MutableList<Location>): String {
        var locations: String = ""
        list.forEach {
            locations += it.description + ", "
        }
        return locations.substring(0, locations.length - 2)
    }
}