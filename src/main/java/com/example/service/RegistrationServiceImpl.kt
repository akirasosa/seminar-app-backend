package com.example.service

import com.example.domain.Registration
import com.example.repository.AwsSettingRepository
import com.example.repository.RegistrationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RegistrationServiceImpl(
    private val registrationRepository: RegistrationRepository,
    private val awsSettingRepository: AwsSettingRepository
) : RegistrationService {

    override fun findOne(ipAddr: String): Registration? {
        return registrationRepository.findOneByIpAddr(ipAddr)
    }

    override fun create(ipAddr: String): Registration {
        val registration = registrationRepository.create(Registration(ipAddr = ipAddr))
        val awsSetting = awsSettingRepository.findAvailableOneForUpdate()
        awsSettingRepository.update(awsSetting.copy(registration = registration))

        return registration
    }

}