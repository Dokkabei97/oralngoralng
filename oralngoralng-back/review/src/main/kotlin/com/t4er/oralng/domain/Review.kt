package com.t4er.oralng.domain

import com.t4er.oralng.entity.AbstractEntity
import com.t4er.oralng.exception.InvalidParamException
import jakarta.persistence.*

@Entity
@Table(name = "reviews")
class Review(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    var id: Long?,

    @Column(name = "user_id")
    var userId: Long,

    @Column(name = "title")
    var title: String,

    @Column(name = "content", columnDefinition = "TEXT")
    var content: String,

    @OneToMany(mappedBy = "review")
    var images: MutableList<Image>? = ArrayList(),

    /**
     * locationTags, themeTags는 각 MutableList<Location>, MutableList<Theme>로 받아
     * String으로 변경 후 db에 저장
     * ex) MutableList<Theme> ["FAMILY", "HEALING"] -> String "FAMILY, HEALING"
     */
    @Column(name = "location_tags")
    var locationTags: String,

    @Column(name = "theme_tags")
    var themeTags: String,

    @Column(name = "comment_count")
    var commentCount: Int,

    @Column(name = "recommend_count")
    var recommendCount: Int,

    @Column(name = "report_count")
    var reportCount: Int,

    ) : AbstractEntity() {

    companion object {
        fun of(
            userId: Long,
            title: String,
            content: String,
            locationTags: String,
            themeTags: String,
        ): Review {
            if (title.length > 30) throw InvalidParamException("제목은 30자 이하만 작성 가능 합니다.")
            return Review(
                null,
                userId,
                title,
                content,
                null,
                locationTags,
                themeTags,
                0,
                0,
                0
            )
        }
    }

    fun update(title: String, content: String, locationTags: String, themeTags: String) {
        this.title = title
        this.content = content
        this.locationTags = locationTags
        this.themeTags = themeTags
    }
}