package _6_40_equals

import kotlinx.coroutines.runBlocking

fun test1(){

    open class Animal
    class Book
//    Animal() == Book()
//    Animal() === Book()

    class Cat: Animal()
    Animal() == Cat()
    Animal() === Cat()

    class Name(val name: String)
    val name1 = Name("Marcin")
    val name2 = Name("Marcin")
    val name1Ref = name1

    name1 == name1
    name1 == name2
    name1 == name1Ref

    name1 === name1
    name1 === name2
    name1 === name1Ref
}

suspend fun main() = runBlocking{
    test1()
}