package org.example.models

class RaceResult(resultId: Int, val raceId: Int, val driverId: Int, val grid: Int, val position: Int?) :
    SerializedF1Entity(resultId) {
    companion object {
        fun from(line: String): RaceResult {
            val values = line.split(",")
            val position = if (values[6].equals("\\N")) null
            else values[6].toInt()
            return RaceResult(values[0].toInt(), values[1].toInt(), values[2].toInt(), values[5].toInt(), position)
        }
    }
}