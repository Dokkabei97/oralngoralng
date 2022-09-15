package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.payment.PayMethod
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

    @Column(name = "card_id")
    var cardId: Long?,

    @Column(name = "price")
    var price: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "pay_type")
    var payType: PayMethod,

    @Column(name = "billing_key")
    var billingKey: String,

    @Column(name= "successed_at")
    var successedAt: ZonedDateTime?,

    @Column(name = "expiration_at")
    var expirationAt: ZonedDateTime,

    @Column(name = "next_order_at")
    var nextOrderAt: ZonedDateTime,

    @Column(name = "result_status")
    var resultStatus: String?,

    @Column(name = "result_message")
    var resultMessage: String?,
) : AbstractEntity() {
    companion object {

    }
}