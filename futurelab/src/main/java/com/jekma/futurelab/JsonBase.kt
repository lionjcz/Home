package com.jekma.futurelab

import com.google.gson.Gson
import java.lang.reflect.Type

open class JsonBase {
    companion object{
        fun toJson(areaGroups: List<Any?>):String{
            return Gson().toJson(areaGroups)
        }

        fun toObject(json: String, type: Type): List<Any> {
            return Gson().fromJson(json, type)
        }
    }

}