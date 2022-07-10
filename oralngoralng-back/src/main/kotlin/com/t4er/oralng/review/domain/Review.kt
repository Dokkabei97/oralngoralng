package com.t4er.oralng.review.domain

import com.t4er.oralng.common.entity.AbstractEntity
import com.t4er.oralng.common.exception.InvalidParamException
import com.t4er.oralng.user.domain.User
import javax.persistence.*

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

    @Column(name = "content", columnDefinition = "text")
    var content: String,

    @Column(name = "hits_count")
    var hitCount: Int,

    @Column(name = "likes_count")
    var likeCount: Int,

    @Column(name = "review_status")
    var reviewStatus: Status,

    ) : AbstractEntity() {

    enum class Status(val description: String) {
        NEW("새 리뷰"),
        HOT("인기 리뷰"),
        HOF("명예의 전당")
    }

    companion object {
        fun of(userId: Long, title: String, content: String): Review {
            if (title.isBlank()) throw InvalidParamException("제목은 필수 입니다.")
            if (content.isBlank()) throw InvalidParamException("내용은 필수 입니다.")

            return Review(null, userId, title, content, 0, 0, Status.NEW)
        }
    }

    fun update(title: String, content: String) {
        if (title.isBlank()) throw InvalidParamException("제목은 필수 입니다.")
        if (content.isBlank()) throw InvalidParamException("내용은 필수 입니다.")

        this.title = title
        this.content = content
    }
}