package org.example

import org.example.fileprocessing.FileLoader
import org.example.models.Circuit
import org.example.models.Driver
import org.example.models.Race
import org.example.models.RaceResult

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val drivers = FileLoader.readFileAndConvertToList<Driver>("drivers.csv", true, Driver::from)
    val circuits = FileLoader.readFileAndConvertToList<Circuit>("circuits.csv", true, Circuit::from)
    val races = FileLoader.readFileAndConvertToList<Race>("races.csv", true, Race::from)
    val results = FileLoader.readFileAndConvertToList<RaceResult>("results.csv", true, RaceResult::from)

    println(drivers.first().toString())
}