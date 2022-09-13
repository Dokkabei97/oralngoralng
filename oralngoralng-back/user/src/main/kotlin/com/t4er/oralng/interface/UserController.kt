package com.t4er.oralng.`interface`

import org.slf4j.LoggerFactory
import com.t4er.oralng.application.UserFacade
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class UserController(val userFacade: UserFacade) {

    private val log = LoggerFactory.getLogger(UserController::class.java)

}