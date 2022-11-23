package com.t4er.oralng.domain

import com.t4er.oralng.domain.CommonEntity.ResultStatus.*
import com.t4er.oralng.entity.AbstractEntity
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var id: Long?,

    @Column(name = "order_token")
    var orderToken: String,

    @Column(name = "user_id")
    var userId: Long,

    @Column(name = "product_id")
    var productId: Long,

    @Column(name = "price")
    var price: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "pay_method")
    var payMethod: PayMethod,

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    var orderStatus: OrderStatus,

    @Column(name = "billing_key")
    var billingKey: String?,

    @Column(name = "order_at")
    var orderAt: ZonedDateTime,

    @Column(name = "expiration_product_at")
    var expirationProductAt: ZonedDateTime?,

    @Column(name = "next_payment_at")
    var nextPaymentAt: ZonedDateTime?,

    @Embedded
    var commonEntity: CommonEntity?,

    ) : AbstractEntity() {

    enum class OrderStatus(val description: String) {
        INIT("주문시작"),
        ORDER_COMPLETE("주문완료"),
    }
}