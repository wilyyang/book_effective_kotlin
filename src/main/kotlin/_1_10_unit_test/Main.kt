package _1_10_unit_test

import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


fun fib(num: Int) : Int = if( num <= 1) 1 else fib(num-1) + fib(num-2)


fun test1(){
    for (i in 0..4)
        println(fib(i))
}



suspend fun main() = runBlocking{
    test1()
}