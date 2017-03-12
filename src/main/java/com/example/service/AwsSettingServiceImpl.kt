package com.example.service

import com.example.domain.AwsSetting
import com.example.repository.AwsSettingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AwsSettingServiceImpl(
   private val awsSettingRepository: AwsSettingRepository
) : AwsSettingService {

    override fun findOneByRegistrationId(id: Long): AwsSetting {
        return awsSettingRepository.findOneByRegistrationId(id)
    }

}