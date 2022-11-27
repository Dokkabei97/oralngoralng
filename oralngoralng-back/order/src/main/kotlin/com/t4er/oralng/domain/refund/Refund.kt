package com.t4er.oralng.domain.refund

import com.t4er.oralng.domain.CommonEntity
import com.t4er.oralng.domain.order.payment.PayMethod
import com.t4er.oralng.entity.AbstractEntity
import jakarta.persistence.*

@Entity
@Table(name = "refunds")
class Refund(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refund_id")
    var id: Long?,

    @Column(name = "refund_token")
    var refundToken: String,

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
    @Column(name = "refund_status")
    var refundStatus: RefundStatus,

    @Embedded
    var commonEntity: CommonEntity?,
) : AbstractEntity() {
    enum class RefundStatus(val description: String) {
        INIT("환불시작"),
        REFUND_COMPLETE("환불완료"),
    }
}