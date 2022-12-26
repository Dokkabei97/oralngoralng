package com.t4er.oralng.domain

import com.t4er.oralng.entity.AbstractEntity
import com.vladmihalcea.hibernate.type.json.JsonType
import jakarta.persistence.*
import org.hibernate.annotations.Type

@Entity
@Table(name = "reviews")
class Review(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    var id: Long,

    @Column(name = "user_id")
    var userId: Long,

    @Column(name = "title")
    var title: String,

    @Column(name = "content", columnDefinition = "TEXT")
    var content: String,

    @OneToMany(mappedBy = "review")
    var images: MutableList<Image> = ArrayList(),

    @Column(name = "location")
    var location: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "theme")
    var theme: Theme,

    @Column(name = "comment_count")
    var commentCount: Int,

    @Column(name = "recommend_count")
    var recommendCount: Int,

    @Column(name = "report_count")
    var reportCount: Int,

    ) : AbstractEntity() {

    enum class Theme {

    }

    companion object {

    }
}