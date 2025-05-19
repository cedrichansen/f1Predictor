package org.example.fileprocessing

abstract class FileHandler {
    companion object {
        val ROOT_PATH = "/Users/cedrichansen/Development/f1Predictor/src/main/resources/"
        fun getFullFilePath(fileName: String): String {
            return "$ROOT_PATH$fileName"
        }
    }
}