package org.example.models

class Race(raceId: Int, val circuitId : Int) : SerializedF1Entity(raceId) {
    companion object {
        fun from(line : String) : Race{
            val values = line.split(",")
            return Race(values[0].toInt(), values[3].toInt())
        }
    }

    override fun additionalFields(): String {
        return "CircuitId - {$circuitId}"
    }
}