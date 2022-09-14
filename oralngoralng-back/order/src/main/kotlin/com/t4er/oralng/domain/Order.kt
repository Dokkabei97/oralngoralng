package com.t4er.oralng.domain

import com.t4er.oralng.entity.AbstractEntity
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

) : AbstractEntity() {

    companion object {

    }
}