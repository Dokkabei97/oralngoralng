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

    @Column(name = "hit_count")
    var hitCount: Int,

    @Column(name = "likes_count")
    var likeCount: Int,
): AbstractEntity() {

    companion object {
        fun of(user: User, title: String, content: String): Review {
            return Review(null, user, title, content, 0, 0)
        }
    }
}