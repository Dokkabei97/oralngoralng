package com.t4er.oralng.domain.order

interface OrderStore {
    fun store(order: Order): Order
}