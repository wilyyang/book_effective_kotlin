package _8_51_use_array

import kotlinx.coroutines.runBlocking
import kotlin.time.measureTime

annotation class Setup
annotation class Benchmark
open class InlineFilterBenchmark {
    lateinit var list: List<Int>
    lateinit var array: IntArray

    @Setup
    fun init() {
        list = List(1_000_000) { it }
        array = IntArray(1_000_000) { it }
    }

    @Benchmark
    fun averageOnIntList(): Double {
        return list.average()
    }

    @Benchmark
    fun averageOnIntArray(): Double {
        return array.average()
    }
}
fun test1(){
    val test = InlineFilterBenchmark()
    test.init()
    val measure1 = measureTime {
        test.averageOnIntList()
    }

    val measure2 = measureTime {
        test.averageOnIntArray()
    }

    println("$measure1 vs $measure2")
}

suspend fun main() = runBlocking{
    test1()
}