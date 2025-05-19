package org.example.fileprocessing

import org.example.models.RaceResult

class RaceResultWriter {

    companion object {
        fun writeRaceResultsToFile(filename : String, raceResults : List<RaceResult>) {
            raceResults.forEach {
                val content = "${it.toJson()},"
                FileWriter.appendToFile(filename, listOf(content))
            }
        }
    }
}