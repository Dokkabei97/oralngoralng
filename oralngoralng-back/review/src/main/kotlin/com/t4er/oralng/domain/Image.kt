package com.t4er.oralng.domain

import com.t4er.oralng.entity.AbstractEntity
import jakarta.persistence.*

@Entity
@Table(name = "images")
class Image(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    var id: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    var review: Review,

    var imageName: String,

    var imageUrl: String,

    ) : AbstractEntity() {

    companion object {
        fun of(review: Review, imageName: String, imageUrl: String): Image {
            // TODO: minio에 이미지 업로드 후 링크 받으면 imageUrl에 미니오 링크 적재 
            return Image(null, review, imageName, imageUrl)
        }
    }
}