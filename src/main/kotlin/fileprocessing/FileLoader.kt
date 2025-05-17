package org.example.fileprocessing

import java.io.BufferedReader
import java.io.File

class FileLoader {

    companion object {
        val ROOT_PATH = "/Users/cedrichansen/Development/f1Predictor/src/main/resources/datasets/f1_data/"
        fun <T> readFileAndConvertToList(
            fileName: String, shouldSkipFirstLine: Boolean, mapper: (String) -> T
        ): List<T> {
            val bufferedReader: BufferedReader = File("$ROOT_PATH$fileName").bufferedReader()
            val relevantLines = bufferedReader.lines().toList().drop(if (shouldSkipFirstLine) 1 else 0);
            return relevantLines.map { l -> mapper.invoke(l) }
        }
    }
}