package com.t4er.oralng.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.apache.commons.lang3.StringUtils
import org.slf4j.MDC
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.util.*

@Component
class CommonHttpRequestInterceptor: HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        var requestEventId = request.getHeader(HEADER_REQUEST_UUID_KEY)
        if (StringUtils.isEmpty(requestEventId)) {
            requestEventId = UUID.randomUUID().toString()
        }
        MDC.put(HEADER_REQUEST_UUID_KEY, requestEventId)
        return true
    }

    companion object {
        const val HEADER_REQUEST_UUID_KEY = "x-request-id"
    }
}