package _2_12_operator_overload

import kotlinx.coroutines.runBlocking


fun Int.factorial() : Int = (1..this).product()
fun Iterable<Int>.product(): Int =
    fold(1) { acc, i -> acc * i }


operator fun Int.not() = factorial()

fun test1(){
    println(10 * 6.factorial())
    println(10 * !6)
    println(10 * 6.not())
}

operator fun Int.times(operation: () -> Unit): () -> Unit =
    { repeat(this) { operation() } }

val tripledHello = 3 * { print("Hello")}

infix fun Int.timesRepeated(operation: () -> Unit) = {
    repeat(this) { operation() }
}

val tripledHello2 = 3 timesRepeated { print("Hello") }
val tripledHello3 = { repeat(3){ print("Hello" )}}
fun test2(){
    tripledHello()
    println()
    tripledHello2()
    println()
    tripledHello3()
}



suspend fun main() = runBlocking{
    test2()
}