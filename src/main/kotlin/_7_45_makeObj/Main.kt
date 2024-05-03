package _7_45_makeObj

import kotlinx.coroutines.runBlocking
import java.math.BigInteger
import kotlin.time.measureTime

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

//fun <T> emptyList(): List<T> {
//    return EMPTY_LIST
//}

class Connection
private val connections = mutableMapOf<String, Connection>()
private fun createConnection(host: String): Connection{
    // search map and create connection
    return Connection()
}
fun getConnection(host:String) = connections.getOrPut(host) { createConnection(host) }

private val FIB_CACHE = mutableMapOf<Int, BigInteger>()

fun fib(n: Int): BigInteger = FIB_CACHE.getOrPut(n) {
    if(n <= 1) BigInteger.ONE else fib(n-1) + fib(n-2)
}

fun fibIter(n: Int): BigInteger {
    if(n<=1) return BigInteger.ONE
    var p = BigInteger.ONE
    var pp = BigInteger.ONE
    for (i in 2..n) {
        val temp = p+pp
        pp = p
        p = temp
    }
    return p
}

fun measurePrint(n: Int, lambda: (Int)-> BigInteger){
    val time = measureTime {
        lambda(n)
    }
    println("${time} ns")
}
fun test4(){
    measurePrint(100, ::fibIter)

    println(">> 100")
    measurePrint(100, ::fibIter)
    measurePrint(100, ::fib)
    measurePrint(100, ::fib)
    println(">> 200")
    measurePrint(200, ::fibIter)
    measurePrint(200, ::fib)
    measurePrint(200, ::fib)
    println(">> 300")
    measurePrint(300, ::fibIter)
    measurePrint(300, ::fib)
    measurePrint(300, ::fib)
    println(">> 400")
    measurePrint(400, ::fibIter)
    measurePrint(400, ::fib)
    measurePrint(400, ::fib)
    println(">> 500")
    measurePrint(500, ::fibIter)
    measurePrint(500, ::fib)
    measurePrint(500, ::fib)
}

fun <T : Comparable<T>> Iterable<T>.countMax(): Int = count { it == this.max()}

fun <T: Comparable<T>> Iterable<T>.countMax2(): Int {
    val max = this.max()
    return count { it == max}
}

private val IS_VALID_EMAIL_REGEX
by lazy { "\\A(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\z".toRegex() }
fun String.isValidIpAddress() = matches(IS_VALID_EMAIL_REGEX)

fun test5(){
    print("5.173.80.254".isValidIpAddress())

    class B
    class C
    class D
    class A {
        val b by lazy { B() }
        val c by lazy { C() }
        val d by lazy { D() }
    }
}

fun Iterable<Int>.maxOrNull():Int? {
//    var max: Int? = null
//    for (i in this){
//        max = if(i > (max ?: Int.MIN_VALUE)) i else max
//    }
//    return max

    val iterator = iterator()
    if(!iterator.hasNext()) return null
    var max: Int = iterator.next()
    while(iterator.hasNext()) {
        val e = iterator.next()
        if (max < e) max = e
    }
    return max
}

public fun <T: Comparable<T>> Iterable<T>.max(): T? {
    val iterator = iterator()
    if(!iterator.hasNext()) return null
    var max = iterator.next()
    while(iterator.hasNext()) {
        val e = iterator.next()
        if (max < e) max = e
    }
    return max
}

suspend fun main() = runBlocking{
    test5()
}