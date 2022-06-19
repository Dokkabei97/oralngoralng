package com.t4er.oralng.review.domain

import com.t4er.oralng.common.entity.AbstractEntity
import javax.persistence.*

@Entity
@Table(name = "reviews")
class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    var id: Long?

): AbstractEntity() {

}