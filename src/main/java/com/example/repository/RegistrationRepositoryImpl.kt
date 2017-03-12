package com.example.repository

import com.example.domain.Registration
import com.example.generated.tables.Registration.REGISTRATION
import com.example.generated.tables.records.RegistrationRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class RegistrationRepositoryImpl(
    private val dsl: DSLContext
) : RegistrationRepository {

    override fun findOneByIpAddr(ipAddr: String): Registration? {
        return dsl.selectFrom(REGISTRATION)
            .where(REGISTRATION.IP_ADDR.eq(ipAddr))
            .fetchOne()
            ?.let(mapper())
    }

    override fun create(registration: Registration): Registration {
        return dsl.insertInto(REGISTRATION, REGISTRATION.IP_ADDR)
            .values(registration.ipAddr)
            .returning()
            .fetchOne()
            .let(mapper())
    }

    private fun mapper() = { r: RegistrationRecord ->
        Registration(
            _id = r.id,
            ipAddr = r.ipAddr
        )
    }

}