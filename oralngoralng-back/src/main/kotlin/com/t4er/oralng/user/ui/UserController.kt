package com.t4er.oralng.user.ui

import com.t4er.oralng.user.application.UserFacade
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(val userFacade: UserFacade) {
}