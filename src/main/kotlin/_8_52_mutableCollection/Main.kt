package _8_52_mutableCollection

import kotlinx.coroutines.runBlocking

operator fun <T> Iterable<T>.plus(element: T): List<T> {
    if(this is Collection) return this.plus(element)
    val result = ArrayList<T>()
    result.addAll(this)
    result.add(element)
    return result
}

inline fun <T, R> Iterable<T>.map(
    transform: (T) -> R
): List<R> {
    val size = if (this is Collection<*>) this.size else 10
    val destination = ArrayList<R>(size)
    for (item in this)
        destination.add(transform(item))
    return destination
}

//inline fun <T, R> Iterable<T>.map(
//    transform: (T) -> R
//): List<R> {
//    var destination = listOf<R>()
//    for (item in this)
//        destination += transform(item)
//    return destination
//}

fun test1(){
    val list = listOf<String>()
    list.plus("").map {  }

}

suspend fun main() = runBlocking{
    test1()
}