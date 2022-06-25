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

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    var user: User,

    @Column(name = "title")
    var title: String,

    @Column(name = "content", columnDefinition = "text")
    var content: String,

    @Column(name = "hits_count")
    var hitCount: Int,

    @Column(name = "likes_count")
    var likeCount: Int,
): AbstractEntity() {

    companion object {
        fun of(user: User, title: String, content: String): Review {
            if (title.isBlank()) throw InvalidParamException("제목은 필수 입니다.")
            if (content.isBlank()) throw InvalidParamException("내용은 필수 입니다.")

            return Review(null, user, title, content, 0, 0)
        }
    }

    fun update(title: String, content: String) {
        if (title.isBlank()) throw InvalidParamException("제목은 필수 입니다.")
        if (content.isBlank()) throw InvalidParamException("내용은 필수 입니다.")

        this.title = title
        this.content = content
    }
}