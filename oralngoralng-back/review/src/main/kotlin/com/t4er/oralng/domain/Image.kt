package com.t4er.oralng.domain

import com.t4er.oralng.entity.AbstractEntity
import jakarta.persistence.*

@Entity
@Table(name = "images")
class Image (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    var review: Review,

    var imageName: String,

    var imageUrl: String,

): AbstractEntity() {

}