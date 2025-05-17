package org.example.fileprocessing

import org.example.datastructures.SerializedF1EntityStore
import org.example.models.Circuit
import org.example.models.Circuit.Companion.from
import org.example.models.Driver
import org.example.models.Driver.Companion.from
import org.example.models.Race
import org.example.models.Race.Companion.from
import org.example.models.RaceResult
import org.example.models.SerializedF1Entity

class DataStoreLoader {
    companion object {
        fun loadDataStore() : SerializedF1EntityStore {
            val drivers = FileLoader.readFileAndConvertToList<Driver>("drivers.csv", true, Driver::from)
            val circuits = FileLoader.readFileAndConvertToList<Circuit>("circuits.csv", true, Circuit::from)
            val races = FileLoader.readFileAndConvertToList<Race>("races.csv", true, Race::from)
            val results = FileLoader.readFileAndConvertToList<RaceResult>("results.csv", true, RaceResult::from)

            val entities = mutableListOf<SerializedF1Entity>()
            entities.addAll(drivers)
            entities.addAll(circuits)
            entities.addAll(races)
            entities.addAll(results)

            return SerializedF1EntityStore.fromList(entities)
        }
    }
}