package org.example.models

import com.google.gson.Gson

abstract class SerializedF1Entity(val entityId: Int) {

    companion object {
        val gson = Gson()
    }

    fun getType() : String {
        return this::class.java.simpleName;
    }

    override fun toString() : String {
        return "${getType()} : ${toJson()}";
    }

    fun toJson() : String {
       return gson.toJson(this)
    }
}