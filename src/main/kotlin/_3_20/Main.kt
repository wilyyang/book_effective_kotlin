package _3_20

import kotlinx.coroutines.runBlocking

fun Iterable<Int>.product() = fold(1) { acc, i -> acc * i}


fun test1(){


}

suspend fun main() = runBlocking{
    test1()
}