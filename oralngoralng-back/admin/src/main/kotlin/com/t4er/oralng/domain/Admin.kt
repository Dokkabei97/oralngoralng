package com.t4er.oralng.domain

import com.t4er.oralng.entity.AbstractEntity
import javax.persistence.*

@Entity
@Table(name = "admins")
class Admin(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    var id: Long?,

    @Column(name = "employee_number")
    var employeeNumber: Int,

    @Column(name = "password")
    var password: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "team")
    var team: Team,

    @Enumerated(EnumType.STRING)
    @Column(name = "admin_level")
    var adminLevel: AdminLevel,
) : AbstractEntity() {

    enum class Team(val description: String) {
        COMMUNITY_TEAM("커뮤니티 팀"),
        RECESS_TEAM("재휴 팀"),
        PLANNING_TEAM("기획 팀"),
        DESIGN_TEAM("디자인 팀"),
        DEV_TEAM("개발 팀")
    }

    enum class AdminLevel(val description: String) {
        BASIC_ADMIN("베이직 어드민, 기본 권한"),
        REPORT_ADMIN("리포트 어드민, 유저 문의 담당"),
        CONTENT_ADMIN("콘텐츠 어드민, 콘텐츠 담당"),
        ANALYSIS_ADMIN("애널리시스 어드민, 데이터 통계 및 분석 담당"),
        SUPER_ADMIN("슈퍼 어드민, 최고 권한")
    }

    companion object {
        fun of(employeeNumber: Int, password: String, team: Team): Admin {
            val adminLevel = when (team) {
                Team.COMMUNITY_TEAM -> AdminLevel.REPORT_ADMIN
                Team.RECESS_TEAM -> AdminLevel.CONTENT_ADMIN
                Team.PLANNING_TEAM -> AdminLevel.ANALYSIS_ADMIN
                else -> AdminLevel.BASIC_ADMIN
            }

            return Admin(
                null,
                employeeNumber,
                password,
                team,
                adminLevel
            )
        }
    }
}