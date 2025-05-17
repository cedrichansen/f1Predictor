package org.example.datastructures

import org.example.models.SerializedF1Entity
import kotlin.collections.mutableMapOf
import kotlin.reflect.KClass

class SerializedF1EntityStore(val data: Map<String, Map<Int, SerializedF1Entity>>) {

    companion object {
        fun fromList(entities: List<SerializedF1Entity>) : SerializedF1EntityStore {
            var map = mutableMapOf<String, MutableMap<Int, SerializedF1Entity>>()
            entities.forEach {
                val entityId = it.getEntityId
                val entityType = it.getType()
                map.putIfAbsent(entityType, mutableMapOf<Int, SerializedF1Entity>())
                map.get(entityType)?.put(entityId, it)
            }
            return SerializedF1EntityStore(map)
        }
    }

    fun <T : SerializedF1Entity> get(id : Int, clazz: Class<T>) : T? {
        val entityType = clazz.simpleName
        return data.get(entityType)?.get(id) as T
    }
}