package com.example.service

import com.example.domain.AwsSetting

interface AwsSettingService {
    fun findOneByRegistrationId(id: Long): AwsSetting
}