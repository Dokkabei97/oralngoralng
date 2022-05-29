package com.t4er.oralng.user.ui

import com.t4er.oralng.user.domain.UserCommand
import com.t4er.oralng.user.domain.UserInfo
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface UserDtoMapper {

    fun of(request: UserDto.RegisterUserRequest): UserCommand.RegisterUserRequest
    fun of(request: UserDto.UpdateUserRequest): UserCommand.UpdateUserRequest
    fun of(request: UserDto.DeleteUserRequest): UserCommand.DeleteUserRequest
    fun of(request: UserDto.GetUserRequest): UserCommand.GetUserRequest

    fun of(response: UserInfo): UserDto.UserResponse
}