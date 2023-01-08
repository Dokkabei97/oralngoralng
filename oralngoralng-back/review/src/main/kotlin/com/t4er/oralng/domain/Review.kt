package com.t4er.oralng.domain

import com.t4er.oralng.domain.tag.Location
import com.t4er.oralng.domain.tag.Theme
import com.t4er.oralng.entity.AbstractEntity
import jakarta.persistence.*

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

    /**
     * locationTags, themeTags는 각 MutableList<Location>, MutableList<Theme>로 받아
     * String으로 변경 후 db에 저장
     * ex) MutableList<Theme> ["FAMILY", "HEALING"] -> String "FAMILY, HEALING"
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "location_tags")
    var locationTags: String,

    @Enumerated(EnumType.STRING)
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

    }
}