package com.t4er.oralng.infrastructure.order

import com.t4er.oralng.domain.order.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
    fun findByOrderToken(orderToken: String): Order
    fun findAllByUserId(userId: Long): List<Order>
}