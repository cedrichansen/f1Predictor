package org.example

import org.example.fileprocessing.DataStoreLoader
import org.example.models.Driver
import org.example.models.Race

fun main() {
    val entityStore = DataStoreLoader.loadDataStore()

    val theRace = entityStore.get(33, Race::class.java)
    val driver = entityStore.get(42, Driver::class.java)

    println(theRace?.toJson())
    println(driver)

    println("All done!")
}