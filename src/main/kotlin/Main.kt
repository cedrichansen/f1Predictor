package org.example

import org.example.fileprocessing.DataStoreLoader
import org.example.models.Driver
import org.example.models.Race
import org.example.models.RaceResult


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val entityStore = DataStoreLoader.loadDataStore()

    val theRace = entityStore.get(33, Race::class.java)
    val driver = entityStore.get(42, Driver::class.java)

    println(theRace)
    println(driver)
}