package com.t4er.oralng.user.ui

import com.t4er.oralng.user.application.UserFacade
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/users")
class UserController(val userFacade: UserFacade) {

    @PostMapping
    fun createUser(@RequestBody @Valid dto: UserDto.CreateUserDto) {
        val toCommand = UserDto.CreateUserDto.toCommand(dto.nickname, dto.email)
        userFacade.createUser(toCommand)

        // TODO: 2022-05-15 반환 값 추가 후 테스트 코드 추가 검증 필요
    }
}