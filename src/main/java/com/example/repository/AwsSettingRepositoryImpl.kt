package com.example.repository

import com.example.domain.AwsSetting
import com.example.generated.tables.AwsSetting.AWS_SETTING
import com.example.generated.tables.records.AwsSettingRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class AwsSettingRepositoryImpl(
    private val dsl: DSLContext
) : AwsSettingRepository {

    override fun findOneByRegistrationId(registrationId: Long): AwsSetting {
        return dsl.selectFrom(AWS_SETTING)
            .where(AWS_SETTING.REGISTRATION_ID.eq(registrationId))
            .limit(1)
            .fetchOne(mapper())
    }

    override fun findAvailableOneForUpdate(): AwsSetting {
        return dsl.selectFrom(AWS_SETTING)
            .where(AWS_SETTING.REGISTRATION_ID.isNull)
            .limit(1)
            .forUpdate()
            .fetchOne()
            .let(mapper())
    }

    override fun update(awsSetting: AwsSetting) {
        val registrationId = requireNotNull(awsSetting.registration?.id)

        dsl.update(AWS_SETTING)
            .set(AWS_SETTING.REGISTRATION_ID, registrationId)
            .where(AWS_SETTING.ID.eq(awsSetting.id))
            .execute()
    }

    private fun mapper() = { r: AwsSettingRecord ->
        AwsSetting(
            _id = r.id,
            username = r.username,
            password = r.password,
            accessKey = r.accessKey,
            region = r.region,
            secretKey = r.secretKey,
            vpcCidr = r.vpcCidr
        )
    }

}