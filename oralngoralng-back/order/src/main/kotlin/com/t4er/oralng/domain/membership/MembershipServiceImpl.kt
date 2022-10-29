package com.t4er.oralng.domain.membership

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MembershipServiceImpl(
        val membershipReader: MembershipReader,
        val membershipStore: MembershipStore
): MembershipService {
}