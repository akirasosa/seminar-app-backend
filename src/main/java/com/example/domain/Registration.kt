package com.example.domain

data class Registration(
    override val _id: Long? = null,

    val ipAddr: String

) : HasIdentity<Long>