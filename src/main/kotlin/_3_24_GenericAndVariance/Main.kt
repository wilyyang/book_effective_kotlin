package _3_24_GenericAndVariance

import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

//class Cup<out T>
class Cup<in T>
open class Dog
class Puppy: Dog()
class Hound: Dog()

fun takeDog(dog: Dog){
    println(dog.javaClass.simpleName)
}

fun test1(){
//    val b : Cup<Dog> = Cup<Puppy>()
    val a : Cup<Puppy> = Cup<Dog>()

//    val anys: Cup<Any> = Cup<Int>()
    val nothings: Cup<Nothing> = Cup<Int>()
}

fun printProcessedNumber(transition: (Int) -> Any){
    println(transition(42))
}

fun test2(){
    val intToDouble: (Int) -> Number = { it.toDouble() }
    val numberAsText: (Number) -> Any = { it.toShort() }
    val identity: (Number) -> Number = { it }
    val numberToInt: (Number) -> Int = { it.toInt() }
    val numberHash: (Any) -> Number = { it.hashCode() }
    val gogo: (Any) -> Int = { it.hashCode() }

    printProcessedNumber(intToDouble)
    printProcessedNumber(numberAsText)
    printProcessedNumber(identity)
    printProcessedNumber(numberToInt)
    printProcessedNumber(numberHash)
    printProcessedNumber(gogo)
}

fun test3(){
    takeDog(Dog())
    takeDog(Puppy())
    takeDog(Hound())
}

//class Box<out T> {
////    var value: T? = null
//    private var value: T? = null
//
//    fun set(value : T){
//        this.value = value
//    }
//
//    fun get(): T = value ?: error("Value not set")
//}
//
//fun test4(){
//    val puppyBox = Box<Puppy>()
//    val dogBox : Box<Dog> = puppyBox
//    dogBox.set(Hound())
//
//    val dogHouse = Box<Dog>()
//    val box: Box<Any> = dogHouse
//    box.set("Some string")
//    box.set(42)
//}

//fun append(list: MutableList<Any>){
//    list.add(42)
//}
//
//fun test5(){
//    val strs = mutableListOf<String>("A", "B", "C")
//    append(strs)
//
//    val str: String = strs[3]
//    print(str)
//}

sealed class Response<out R, out E>
class Failure<out E>(val error: E): Response<Nothing, E>()
class Success<out R>(val value: R): Response<R, Nothing>()

open class Car
interface Boat
class Amphibious: Car(), Boat

fun getAmphibious(): Amphibious {
    return Amphibious()
}

fun test6(){
    val car: Car = getAmphibious()
    val boat: Boat = getAmphibious()
}

//class Box<in T>(
//    val value : T
//)
//
//fun test7(){
//    val garage: Box<Car> = Box(Car())
//    val amphibiousSpot: Box<Amphibious> = garage
////    val boat : Boat = garage.value
//
//    val noSpot: Box<Nothing> = Box<Car>(Car())
//    val boat: Nothing = noSpot.value
//}

class Box<in T> {
    private var value: T? = null

    fun set(value : T){
        this.value = value
    }

    private fun get(): T = value
        ?: error("Value not set")
}

public interface Continuation<in T> {
    public val context: CoroutineContext
    public fun resumeWith(result: Result<T>)
}

class Box2<out T>(val value: T)
val boxStr: Box2<String> = Box2("Str")
val boxAny: Box2<Any> = boxStr

class Box3<T>(val value: T)
val boxStr3: Box3<String> = Box3("Str")
val boxAny3: Box3<out Any> = boxStr3

class QQQ{
    interface Dog
    interface Cutie
    data class Puppy(val name : String): Dog, Cutie
    data class Hound(val name : String): Dog
    data class Cat(val name : String): Cutie

    fun fillWithPuppies(list: MutableList<in Puppy>){
        list.add(Puppy("Jim"))
        list.add(Puppy("Beam"))
    }


    fun test8(){
        val dogs = mutableListOf<Dog>(Hound("Pluto"))
        fillWithPuppies(dogs)
        println(dogs)

        val animals = mutableListOf<Cutie>(Cat("Felix"))
        fillWithPuppies(animals)
        println(animals)
    }
}


suspend fun main() = runBlocking{
    val t = QQQ()
    t.test8()
}