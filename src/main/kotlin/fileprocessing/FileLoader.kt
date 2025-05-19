package org.example.fileprocessing

import java.io.BufferedReader
import java.io.File

class FileLoader : FileHandler() {

    companion object {
        fun <T> readFileAndConvertToList(
            fileName: String, shouldSkipFirstLine: Boolean, mapper: (String) -> T
        ): List<T> {
            val relevantLines = readFile(fileName, shouldSkipFirstLine)
            return relevantLines.map { l -> mapper.invoke(l) }
        }

        fun readFile(fileName: String, shouldSkipFirstLine: Boolean): List<String> {
            val bufferedReader: BufferedReader = File(getFullFilePath(fileName)).bufferedReader()
            val relevantLines = bufferedReader.lines().toList().drop(if (shouldSkipFirstLine) 1 else 0);
            return relevantLines
        }
    }
}