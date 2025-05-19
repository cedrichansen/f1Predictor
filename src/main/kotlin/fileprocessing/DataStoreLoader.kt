package org.example.fileprocessing

import org.example.datastructures.SerializedF1EntityStore
import org.example.models.Circuit
import org.example.models.Driver
import org.example.models.Race
import org.example.models.RaceResult
import org.example.models.SerializedF1Entity

class DataStoreLoader {
    companion object {
        fun loadDataStore(): SerializedF1EntityStore {
            val drivers =
                FileLoader.readFileAndConvertToList<Driver>("datasets/f1_data/drivers.csv", true, Driver::from)
            val circuits =
                FileLoader.readFileAndConvertToList<Circuit>("datasets/f1_data/circuits.csv", true, Circuit::from)
            val races = FileLoader.readFileAndConvertToList<Race>("datasets/f1_data/races.csv", true, Race::from)
            val results =
                FileLoader.readFileAndConvertToList<RaceResult>("datasets/f1_data/results.csv", true, RaceResult::from)

            val entities = mutableListOf<SerializedF1Entity>()
            entities.addAll(drivers)
            entities.addAll(circuits)
            entities.addAll(races)
            entities.addAll(results)

            return SerializedF1EntityStore.fromList(entities)
        }
    }
}