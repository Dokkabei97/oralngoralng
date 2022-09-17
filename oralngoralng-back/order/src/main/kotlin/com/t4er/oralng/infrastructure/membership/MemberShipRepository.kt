package com.t4er.oralng.infrastructure.membership

import com.t4er.oralng.domain.membership.Membership
import org.springframework.data.jpa.repository.JpaRepository

interface MemberShipRepository: JpaRepository<Membership, Long> {
}