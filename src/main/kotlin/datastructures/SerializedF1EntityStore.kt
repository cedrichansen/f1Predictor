package org.example.datastructures

import org.example.models.Race
import org.example.models.RaceResult
import org.example.models.SerializedF1Entity
import kotlin.collections.mutableMapOf

class SerializedF1EntityStore(val data: Map<String, Map<Int, SerializedF1Entity>>) {

    init {
        associateRaceResultsToRace()
    }

    companion object {
        fun fromList(entities: List<SerializedF1Entity>): SerializedF1EntityStore {
            var map = mutableMapOf<String, MutableMap<Int, SerializedF1Entity>>()
            entities.forEach {
                val entityId = it.entityId
                val entityType = it.getType()
                map.putIfAbsent(entityType, mutableMapOf<Int, SerializedF1Entity>())
                map.get(entityType)?.put(entityId, it)
            }
            return SerializedF1EntityStore(map)
        }
    }

    fun <T : SerializedF1Entity> getAllOfType(clazz: Class<T>): Map<Int, T>? {
        val entityType = clazz.simpleName
        return data[entityType] as Map<Int, T>
    }

    fun <T : SerializedF1Entity> get(id: Int, clazz: Class<T>): T? {
        val entitiesForType = getAllOfType(clazz)
        return entitiesForType?.get(id)
    }

    private fun associateRaceResultsToRace() {
        //RaceId - > List<RaceResult>
        val raceToResultsMap = mutableMapOf<Int, MutableList<RaceResult>>()

        val results = data.get(RaceResult::class.java.simpleName)!!.values as Collection<RaceResult>
        results.forEach {
            raceToResultsMap.putIfAbsent(it.raceId, mutableListOf<RaceResult>())
            raceToResultsMap.get(it.raceId)!!.add(it)
        }

        raceToResultsMap.entries.forEach {
            val raceAssociatedWithTheResults = get(it.key, Race::class.java)
            raceAssociatedWithTheResults!!.addRaceResults(it.value)
        }
        println("Done associating raceresuls to corresponding races")
    }
}