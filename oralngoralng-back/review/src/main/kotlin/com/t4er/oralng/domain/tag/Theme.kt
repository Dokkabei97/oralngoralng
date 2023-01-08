package com.t4er.oralng.domain.tag

class Theme {
    enum class People(val description: String) {
        FAMILY("가족 여행"),
        FRIEND("우정 여행"),
        COUPLE("커플 여행"),
        SOLO("혼자 여행")
    }

    enum class Concept(val description: String) {
        HEALING("힐링 여행"),
        FOOD("식도락 여행"),
        HISTORICAL("역사 탐방 여행")
    }
}