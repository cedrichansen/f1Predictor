package org.example.models

abstract class SerializedF1Entity(val getEntityId: Int) {
    abstract fun additionalFields(): String

    fun getType() : String {
        return this::class.java.simpleName;
    }

    fun getEntityKey() : String {
        return "$getEntityId-${getType()}"
    }

    override fun toString() : String {
        return "${getEntityKey()} - Fields: {${additionalFields()}}";
    }
}