package org.example.models

class Race(raceId: Int, val circuitId : Int, var results: List<RaceResult >) : SerializedF1Entity(raceId) {
    companion object {
        fun from(line : String) : Race{
            val values = line.split(",")
            return Race(values[0].toInt(), values[3].toInt(), listOf())
        }
    }

    fun addRaceResults(raceResults: List<RaceResult>)  {
        results = raceResults
    }
}