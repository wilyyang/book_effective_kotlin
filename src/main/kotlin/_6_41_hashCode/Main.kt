package _6_41_hashCode

import kotlinx.coroutines.runBlocking
import java.util.*

fun test1(){
    data class FullName(
        var name : String,
        var surname : String
    )

    val person = FullName("Maja", "Markiewicz")
    val set = mutableSetOf<FullName>()
    set.add(person)

    println(">> 1. not modified $person")
    println(">> contains : ${person in set}")
    println(">> obj hashCode : ${person.hashCode()}")
    println(">> set hashCode : ${set.first().hashCode()}")
    println(">> equals : ${set.first() == person}")
    println()

    person.surname = "Moskala"

    println(">> 2. modified $person")
    println(">> contains : ${person in set}")
    println(">> obj hashCode : ${person.hashCode()}")
    println(">> set hashCode : ${set.first().hashCode()}")
    println(">> equals : ${set.first() == person}")
    println()

//    person.surname = "Markiewicz"

    val Markiewicz = FullName("Maja", "Markiewicz")
    println(">> 3. new obj $Markiewicz")
    println(">> contains : ${Markiewicz in set}")
    println(">> obj hashCode : ${Markiewicz.hashCode()}")
    println(">> set hashCode : ${set.first().hashCode()}")
    println(">> person : ${person == Markiewicz}")
    println(">> equals : ${set.first() == Markiewicz}")
    println()

    val Moskala = FullName("Maja", "Moskala")
    println(">> 4. new obj $Moskala")
    println(">> contains : ${Moskala in set}")
    println(">> obj hashCode : ${Moskala.hashCode()}")
    println(">> set hashCode : ${set.first().hashCode()}")
    println(">> person : ${person == Moskala}")
    println(">> equals : ${set.first() == Moskala}")
    println()
}

fun test2() {
    class FullName(
        var name: String,
        var surname: String
    ) {
        override fun equals(other: Any?): Boolean =
            other is FullName
                    && other.name == name
                    && other.surname == surname
    }

    val set = mutableSetOf<FullName>()
    set.add(FullName("Marcin", "Moskala"))
    val p = FullName("Marcin", "Moskala")
    println(p in set)
    println(p == set.first())
}

class Proper(val name: String){
    override fun equals(other: Any?): Boolean {
        equalsCounter++
        return other is Proper && name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object{
        var equalsCounter = 0
    }
}

class Terrible(val name: String){
    override fun equals(other: Any?): Boolean {
        equalsCounter++
        return other is Terrible && name == other.name
    }

    override fun hashCode() = 0

    companion object{
        var equalsCounter = 0
    }
}


fun test3(){
    val properSet = List(10000) { Proper("$it") }.toSet()
    println(Proper.equalsCounter)
    val terribleSet = List(10000){ Terrible("$it")}.toSet()
    println(Terrible.equalsCounter)

    Proper.equalsCounter = 0
    println(Proper("9999") in properSet)
    println(Proper.equalsCounter)

    Proper.equalsCounter = 0
    println(Proper("A") in properSet)
    println(Proper.equalsCounter)

    Terrible.equalsCounter = 0
    println(Terrible("9999") in terribleSet)
    println(Terrible.equalsCounter)

    Terrible.equalsCounter = 0
    println(Terrible("A") in terribleSet)
    println(Terrible.equalsCounter)

}

class DateTime(
    private var millis: Long = 0L,
    private var timeZone: TimeZone? = null
){
    private var asStringCache = ""
    private var changed = false

    override fun equals(other: Any?): Boolean =
        other is DateTime &&
                other.millis == millis &&
                other.timeZone == timeZone

    override fun hashCode(): Int {
        var result = millis.hashCode()
        result = result * 31 + timeZone.hashCode()
        return result

//        Objects.hash(timeZone, millis)
//        hashCodeOf(timeZone, millis)
    }

    inline fun hashCodeOf(vararg values: Any?) =
        values.fold(0){ acc, value ->
            (acc * 31) + value.hashCode()
        }
}


data class DateTime2(
    private var millis: Long = 0L,
    private var timeZone: TimeZone? = null
){
    private var asStringCache = ""
    private var changed = false
}

fun test4(){

}


suspend fun main() = runBlocking{
    test4()
}