package com.t4er.oralng.domain.refund

import com.t4er.oralng.domain.CommonEntity
import com.t4er.oralng.domain.order.payment.PayMethod
import com.t4er.oralng.entity.AbstractEntity
import java.time.ZonedDateTime
import javax.persistence.*

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

    @Column(name = "card_id")
    var cardId: Long?,

    @Column(name = "price")
    var price: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "pay_type")
    var payType: PayMethod?,

    @Column(name = "billing_key")
    var billingKey: String?,

    @Embedded
    var commonEntity: CommonEntity?,
) : AbstractEntity()