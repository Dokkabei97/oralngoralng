package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.CommonEntity
import com.t4er.oralng.domain.order.payment.PayMethod
import com.t4er.oralng.entity.AbstractEntity
import com.t4er.oralng.util.TokenGenerator
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
    @Column(name = "pay_method")
    var payMethod: PayMethod?,

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
    companion object {
        private const val ORDER_PREFIX: String = "ord_"
        fun of(userId: Long, productId: Long, price: Int): Order {
            return Order(
                null,
                TokenGenerator.randomCharacterWithPrefix(ORDER_PREFIX),
                userId,
                productId,
                null,
                price,
                null,
                null,
                ZonedDateTime.now(),
                null,
                null,
                null
            )
        }
    }
}