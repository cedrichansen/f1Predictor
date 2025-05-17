package org.example.datastructures

import org.example.models.SerializedF1Entity
import kotlin.collections.mutableMapOf

class SerializedF1EntityStore(data: Map<Int, Map<String, SerializedF1EntityStore>>) {

    companion object {
        fun fromList(entities: List<SerializedF1Entity>) : SerializedF1Entity {
            var map = mutableMapOf<Int, Map<String, SerializedF1EntityStore>>()

        }

        fun Map<Int, Map<String, SerializedF1EntityStore>>.putEntity(data: Map<Int, Map<String, SerializedF1EntityStore>>, entityToAdd: SerializedF1Entity) {

        }
    }


    fun get(id : Int, clazz: Class<in SerializedF1Entity>) : SerializedF1Entity {

    }






}