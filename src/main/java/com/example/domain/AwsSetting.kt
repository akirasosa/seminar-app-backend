package com.example.domain

data class AwsSetting(
    override val _id: Long? = null,
    val username: String,
    val password: String,
    val accessKey: String,
    val secretKey: String,
    val region: String,
    val vpcCidr: String,
    val registration: Registration? = null
) : HasIdentity<Long>