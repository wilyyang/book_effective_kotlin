package _1_9_use

import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun countCharactersInFile(path: String) : Int {
//    val reader = BufferedReader(FileReader(path))
//    reader.use {
//        return reader.lineSequence().sumBy { it.length }
//    }

//    BufferedReader(FileReader(path)).use { reader ->
//        return reader.lineSequence().sumBy { it.length }
//    }

    File(path).useLines { lines ->
        return lines.sumBy { it.length }
    }
}

fun countCharactersInFile2(path: String): Int =
    File(path).useLines { lines ->
        lines.sumBy { it.length }
    }

fun test1(){



}


suspend fun main() = runBlocking{
    test1()
}