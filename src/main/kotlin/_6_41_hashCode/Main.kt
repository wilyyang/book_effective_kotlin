package _6_41_hashCode

import kotlinx.coroutines.runBlocking

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

suspend fun main() = runBlocking{
    test2()
}