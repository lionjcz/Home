package com.jekma.futurelab

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import java.lang.reflect.Type

class MemberLocalModel(application: Application) : BaseModel() {
    private val mPreferences: SharedPreferences
    fun saveAreaGroup(areaGroups: List<AreaGroup?>): Boolean {
        return mPreferences.edit().putString(SP_MEMBER_AREA_GROUP_JSON, JsonBase.toJson(areaGroups))
            .commit()
    }

    val areaGroup: List<AreaGroup>
        get() {
            val json = mPreferences.getString(SP_MEMBER_AREA_GROUP_JSON, "")
            val type: Type = object : TypeToken<List<AreaGroup?>?>() {}.getType()
            return if (json!!.isEmpty()) {
                ArrayList()
            }
            else JsonBase.toObject(json, type) as List<AreaGroup>
        }

    fun saveAuthToken(authToken: String): Boolean {
        return mPreferences.edit().putString(SP_MEMBER_AUTH_TOKEN, authToken).commit()
    }

    val authToken: String
        get() = mPreferences.getString(SP_MEMBER_AUTH_TOKEN, "")!!

    fun savePushToken(authToken: String): Boolean {
        return mPreferences.edit().putString(SP_MEMBER_PUSH_TOKEN, authToken).commit()
    }

    val pushToken: String
        get() = mPreferences.getString(SP_MEMBER_PUSH_TOKEN, "")!!

    fun saveAccount(account: String): Boolean {
        return mPreferences.edit().putString(SP_MEMBER_ACCOUNT, account).commit()
    }

    val account: String
        get() = mPreferences.getString(SP_MEMBER_ACCOUNT, "")!!

    fun saveFamilyName(familyName: String): Boolean {
        return mPreferences.edit().putString(SP_MEMBER_FAMILY_NAME, familyName).commit()
    }

    val familyName: String
        get() = mPreferences.getString(SP_MEMBER_FAMILY_NAME, "")!!

    fun saveDevice(devices: List<Device?>): Boolean {
        return mPreferences.edit().putString(SP_MEMBER_DEVICE_JSON, JsonBase.toJson(devices)).commit()
    }

    val device: List<Device>
        get() {
            val json = mPreferences.getString(SP_MEMBER_DEVICE_JSON, "")
            val type: Type = object : TypeToken<List<Device?>?>() {}.type
            return if (json!!.isEmpty()) {
                ArrayList()
            }
            else JsonBase.toObject(json, type)as List<Device>
        }

    companion object {
        private const val SP_MEMBER = "sp_member"
        private const val SP_MEMBER_AUTH_TOKEN = "sp_member_auth_token"
        private const val SP_MEMBER_PUSH_TOKEN = "sp_member_push_token"
        private const val SP_MEMBER_ACCOUNT = "sp_member_account"
        private const val SP_MEMBER_FAMILY_NAME = "sp_member_family_name"
        private const val SP_MEMBER_AREA_GROUP_JSON = "sp_member_area_name_json"
        private const val SP_MEMBER_DEVICE_JSON = "sp_member_device_json"
    }

    init {
        mPreferences = application.getSharedPreferences(SP_MEMBER, Context.MODE_PRIVATE)
    }
}