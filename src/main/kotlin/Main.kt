package org.example

import org.example.datastructures.SerializedF1EntityStore
import org.example.fileprocessing.FileLoader
import org.example.models.Circuit
import org.example.models.Driver
import org.example.models.Race
import org.example.models.RaceResult
import org.example.models.SerializedF1Entity
import kotlin.reflect.KClass

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val drivers = FileLoader.readFileAndConvertToList<Driver>("drivers.csv", true, Driver::from)
    val circuits = FileLoader.readFileAndConvertToList<Circuit>("circuits.csv", true, Circuit::from)
    val races = FileLoader.readFileAndConvertToList<Race>("races.csv", true, Race::from)
    val results = FileLoader.readFileAndConvertToList<RaceResult>("results.csv", true, RaceResult::from)

    val entities = mutableListOf<SerializedF1Entity>()
    entities.addAll(drivers)
    entities.addAll(circuits)
    entities.addAll(races)
    entities.addAll(results)

    val entityStore = SerializedF1EntityStore.fromList(entities)

    val theRace = entityStore.get(33, RaceResult::class.java)
    val driver = entityStore.get(42, Driver::class.java)

    println(theRace)
    println(driver)
}