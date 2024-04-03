package _3_22_Generic

import kotlinx.coroutines.runBlocking

inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> {
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            destination.add(element)
        }
    }
    return destination
}

fun <T : Comparable<T>> Iterable<T>.sorted() : List<T> {
    /**/
    return listOf()
}

//fun <T, C : MutableCollection<in T>>
//        Iterable<T>.toCollection(destination: C): C {
//
//}

//class ListAdapter<T : ItemAdapter> (){}

inline fun <T, R : Any> Iterable<T>.mapNotNull(
    transform: (T) -> R?
): List<R> {
    return mapNotNullTo(ArrayList<R>(), transform)
}

open class Animal
interface GoodTempered
class GoodTemperedChild : Animal(), GoodTempered

//fun <T: Animal> pet(animal : T) where T: GoodTempered {
//
//}

fun <T> pet(animal: T) where T: Animal, T : GoodTempered {
}

fun test1(){


}

suspend fun main() = runBlocking{
    test1()
}