package org.example.models

abstract class SerializedF1Entity(val getEntityId: Int) {
    abstract fun additionalFields(): String

    private fun getClassName() : String {
        return this::class.java.simpleName;
    }

    fun getEntityKey() : String {
        return "$getEntityId-${getClassName()}"
    }

    override fun toString() : String {
        return "${getEntityKey()} - Fields: {${additionalFields()}}";
    }
}