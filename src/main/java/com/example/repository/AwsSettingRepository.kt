package com.example.repository

import com.example.domain.AwsSetting

interface AwsSettingRepository {

    fun findAvailableOneForUpdate(): AwsSetting
    fun update(awsSetting: AwsSetting)
    fun findOneByRegistrationId(registrationId: Long): AwsSetting
}