package com.t4er.oralng.infrastructure.membership

import com.t4er.oralng.domain.membership.MembershipStore
import org.springframework.stereotype.Component

@Component
class MembershipStoreImpl(val memberShipRepository: MemberShipRepository): MembershipStore {

}