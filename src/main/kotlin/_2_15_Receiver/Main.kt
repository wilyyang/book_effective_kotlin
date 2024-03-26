package _2_15_Receiver

import kotlinx.coroutines.runBlocking

open class Person
class User: Person() {
    private var beersDrunk: Int = 0
    fun drinkBeers(num : Int) {
        this.beersDrunk += num
    }
}

fun <T: Comparable<T>> List<T>.quickSort0(): List<T> {
    if(size < 2) return this
    val pivot = first()
    val (smaller, bigger) = drop(1).partition { it < pivot }
    return smaller.quickSort() + pivot + bigger.quickSort()
}

fun <T: Comparable<T>> List<T>.quickSort(): List<T> {
    if(this.size < 2) return this
    val pivot = this.first()
    val (smaller, bigger) = this.drop(1)
        .partition { it < pivot }
    return smaller.quickSort() + pivot + bigger.quickSort()
}

fun test1(){
    println(listOf(3,2,5,1,6).quickSort0())
    println(listOf("C", "D", "A", "B").quickSort())
}


class Node(val name : String) {
//    fun makeChild(childName: String) =
//        create("$name.$childName")
//            .also { print("Created ${it?.name}")}

    fun makeChild(childName: String) =
        create("$name.$childName").apply {
            print("Created ${this?.name} in" +
                    " ${this@Node.name}")
        }

    fun create(name: String) : Node? = Node(name)
}

fun test2(){
    val node = Node("parent")
    node.makeChild("child")
}

@DslMarker
annotation class HtmlDsl

fun table(f: TableDsl.() -> Unit){}

@HtmlDsl
class TableDsl {}


suspend fun main() = runBlocking{
    test2()
}