package com.example.repository

import com.example.domain.Registration

interface RegistrationRepository {

    fun create(registration: Registration): Registration
    fun findOneByIpAddr(ipAddr: String): Registration?
}