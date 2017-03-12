package com.example.controller

import com.example.domain.Registration
import com.example.service.RegistrationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/registrations")
class RegistrationController(
    private val registrationService: RegistrationService
) {

    @PostMapping
    fun create(req: HttpServletRequest): Registration {
        return registrationService.create(req.remoteAddr)
    }

    @GetMapping
    fun show(req: HttpServletRequest): Registration? {
        return registrationService.findOne(req.remoteAddr)
    }
}