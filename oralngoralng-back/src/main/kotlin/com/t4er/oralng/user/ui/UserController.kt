package com.t4er.oralng.user.ui

import com.t4er.oralng.common.response.CommonResponse
import com.t4er.oralng.user.application.UserFacade
import com.t4er.oralng.user.domain.UserCommand
import com.t4er.oralng.user.ui.UserDto.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(val userFacade: UserFacade, val userDtoMapper: UserDtoMapper) {

    @PostMapping
    fun registerUser(@RequestBody @Validated request: RegisterUserRequest): CommonResponse<*> {
        val of = userDtoMapper.of(request)
        val registerUser = userFacade.registerUser(of)
        val response = userDtoMapper.of(registerUser)
        return CommonResponse.success(response)
    }

    @DeleteMapping
    fun deleteUser(@RequestBody @Validated request: DeleteUserRequest): CommonResponse<*> {
        val of = userDtoMapper.of(request)
        userFacade.deleteUser(of)
        return CommonResponse.success(HttpStatus.OK)
    }

    @GetMapping
    fun getUser(@RequestBody @Validated request: GetUserRequest): CommonResponse<*> {
        val of = userDtoMapper.of(request)
        val user = userFacade.getUser(of)
        return CommonResponse.success(user)
    }
}