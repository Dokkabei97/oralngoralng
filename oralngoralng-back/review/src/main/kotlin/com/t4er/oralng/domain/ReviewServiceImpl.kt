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
    override fun create(review: CreateReviewRequest) {
        val locations: String = locationListToString(review.locationTags)
        val themes: String = themeListToString(review.themeTags)
        val images: MutableMap<String, MutableMap<String, String>> = imageListToMap(review.images)
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

    @Transactional
    override fun update(review: UpdateReviewRequest) {
        val findById: Review = reviewReader.getReview(review.reviewId)
        val locations: String = locationListToString(review.locationTags)
        val themes: String = themeListToString(review.themeTags)
        val images: MutableMap<String, MutableMap<String, String>> = imageListToMap(review.images)
        findById.update(review.title, review.content, images, locations, themes)
    }

    @Transactional
    override fun delete(review: DeleteReviewRequest) {
        reviewStore.delete(review.reviewId)
    }

    private fun imageListToMap(list: MutableList<Image>): MutableMap<String, MutableMap<String, String>> {
        val images: MutableMap<String, MutableMap<String, String>> = HashMap()
        val imageLists: MutableMap<String, String> = HashMap()
        for ((index, image) in list.withIndex()) {
            imageLists.put("imageUrl", image.imageUrl)
            imageLists.put("imageDescription", image.imageDescription)
            images.put("image"+index, imageLists)
        }

        return hashMapOf()
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