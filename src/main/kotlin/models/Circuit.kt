package org.example.models

class Circuit (circuitId : Int, val circuitName: String): SerializedF1Entity(circuitId) {
    companion object {
        fun from(line: String): Circuit {
            val values = line.split(",")
            return Circuit(values[0].toInt(), values[1].replace("\"", ""))
        }
    }

    override fun additionalFields(): String {
        return "circuitName: $circuitName"
    }
}