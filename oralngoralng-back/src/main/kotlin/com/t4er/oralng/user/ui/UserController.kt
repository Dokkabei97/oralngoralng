package com.t4er.oralng.user.ui

import com.t4er.oralng.user.application.UserFacade
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/users")
class UserController(val userFacade: UserFacade) {

    @PostMapping
    fun createUser(@RequestBody @Valid dto: UserDto.CreateUserRequest) : ResponseEntity<UserDto.CreateUserResponse> {
        val toCommand = UserDto.CreateUserRequest.toCommand(dto.nickname, dto.email)
        val createUser = userFacade.createUser(toCommand)

        return ResponseEntity<UserDto.CreateUserResponse>(UserDto.CreateUserResponse(createUser.nickname, createUser.email), HttpStatus.OK)
        // TODO: 2022-05-18 반환 값 변경 필요
    }
}