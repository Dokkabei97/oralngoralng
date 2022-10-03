package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.CommonEntity
import com.t4er.oralng.domain.order.payment.PayMethod
import java.time.ZonedDateTime

class OrderInfo(order: Order) {
    var orderToken: String = order.orderToken
    var userId: Long = order.userId
    var productId: Long = order.productId
    var price: Int = order.price
    var payMethod: PayMethod = order.payMethod
    var orderStatus: Order.OrderStatus = order.orderStatus
    var billingKey: String? = order.billingKey
    var orderAt: ZonedDateTime = order.orderAt
    var expirationProductAt: ZonedDateTime? = order.expirationProductAt
    var nextPaymentAt: ZonedDateTime? = order.nextPaymentAt
    var commonEntity: CommonEntity? = order.commonEntity
}