package com.example.controller

import com.example.domain.AwsSetting
import com.example.service.AwsSettingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/aws_settings")
class AwsSettingController(
    private val awsSettingService: AwsSettingService
) {

    @GetMapping(value = "/registration_id/{id}")
    fun showByRegistrationId(@PathVariable("id") id: Long): AwsSetting {
        return awsSettingService.findOneByRegistrationId(id)

    }

}