package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.CommonEntity
import com.t4er.oralng.domain.CommonEntity.ResultStatus.*
import com.t4er.oralng.domain.order.Order.OrderStatus.*
import com.t4er.oralng.domain.order.payment.PayMethod
import com.t4er.oralng.entity.AbstractEntity
import com.t4er.oralng.exception.IllegalStatusException
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

    companion object {
        private const val ORDER_PREFIX: String = "ord_"
        private const val BILLING_KEY_PREFIX: String = "bk_"

        fun of(userId: Long, productId: Long, price: Int, payMethod: PayMethod): Order {
            return Order(
                null,
                TokenGenerator.randomCharacterWithPrefix(ORDER_PREFIX),
                userId,
                productId,
                price,
                payMethod,
                INIT,
                null,
                ZonedDateTime.now(),
                null,
                null,
                null
            )
        }
    }

    // kotlin 문법
    fun isAlreadyPaymentComplete(): Boolean = when (this.orderStatus) {
        ORDER_COMPLETE -> true
        INIT -> false
    }

    fun orderSuccess() {
        if (this.orderStatus != INIT) throw IllegalStatusException()
        this.billingKey = TokenGenerator.randomCharacterWithPrefix(BILLING_KEY_PREFIX)
        this.orderStatus = ORDER_COMPLETE
        this.commonEntity = CommonEntity.of(ZonedDateTime.now(), SUCCESS, "주문 성공")
    }

    fun orderFail() {
        this.billingKey = TokenGenerator.randomCharacterWithPrefix(BILLING_KEY_PREFIX)
        this.commonEntity = CommonEntity.of(null, FAIL, "주문 실패")
    }
}