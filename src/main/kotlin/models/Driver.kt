package org.example.models

class Driver (id : Int, val name: String): SerializedF1Entity(id) {
    companion object {
        fun from(line : String) : Driver{
            val values = line.split(",")
            return Driver(values[0].toInt(), values[1].replace("\"", ""))
        }
    }
}