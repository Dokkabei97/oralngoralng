package com.t4er.oralng.infrastructure.membership

import com.t4er.oralng.domain.membership.MembershipReader
import org.springframework.stereotype.Component

@Component
class MembershipReaderImpl(val memberShipRepository: MemberShipRepository): MembershipReader {
}