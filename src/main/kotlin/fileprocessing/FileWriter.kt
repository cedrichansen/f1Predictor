package org.example.fileprocessing

import java.io.File
import java.io.FileOutputStream

class FileWriter : FileHandler() {

    companion object {
        fun appendToFile(filename: String, fileContents: List<String>) {
            val file = File(getFullFilePath(filename))
            FileOutputStream(file, true).bufferedWriter().use { writer ->
                fileContents.forEach { writer.write(it) }
            }
        }
    }
}