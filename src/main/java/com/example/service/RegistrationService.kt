package com.example.service

import com.example.domain.Registration

interface RegistrationService {
    fun create(ipAddr: String): Registration
    fun findOne(ipAddr: String): Registration?
}