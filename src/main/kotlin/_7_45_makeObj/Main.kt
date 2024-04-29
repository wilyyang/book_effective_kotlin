package _7_45_makeObj

import kotlinx.coroutines.runBlocking

fun test1(){
    val str1 = "Lorem ipsum dolor sit amet"
    val str2 = "Lorem ipsum dolor sit amet"
    println(str1 == str2)
    println(str1 === str2)

    val i1: Int? = 1
    val i2: Int? = 1
    println(i1 == i2)
    println(i1 === i2)

    val j1: Int? = 1234
    val j2: Int? = 1234
    println(j1 == j2)
    println(j1 === j2)
}

class Blackhole {
    fun consume(target: Any?){
        val measureTime = kotlin.time.measureTime {
            target
        }
        println("벤치마크 결과 : $measureTime ns/op")
    }
}
class A
private val a = A()

fun accessA(blackhole: Blackhole){
    blackhole.consume(a)
}

fun createA(blackhole: Blackhole){
    blackhole.consume(A())
}

fun createListAccessA(blackhole: Blackhole){
    blackhole.consume(List(1000) { a })
}

fun createListCreateA(blackhole: Blackhole){
    blackhole.consume(List(1000) { A() })
}

fun test2(){
    val blackhole = Blackhole()
    accessA(blackhole)
    createA(blackhole)
    createListAccessA(blackhole)
    createListCreateA(blackhole)
}

sealed class LinkedList<out T>
class Node<out T>(
    val head: T,
    val tail: LinkedList<T>
): LinkedList<T>()

object Empty: LinkedList<Nothing>()

fun test3(){
    val list: LinkedList<Int> =
        Node(1, Node(2, Node(3, Empty)))
    val list2: LinkedList<String> =
        Node("A", Node("B", Empty))
}



suspend fun main() = runBlocking{
    test3()
}