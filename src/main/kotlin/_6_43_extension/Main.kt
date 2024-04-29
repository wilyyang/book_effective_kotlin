package _6_43_extension

import kotlinx.coroutines.runBlocking
import kotlin.contracts.contract

data class DateTime(val millis: Long)
class Event
val date = DateTime(millis = 0L)

fun test1(){
    class Workshop(val name : String){
        fun makeEvent(date: DateTime): Event = Event()
        val permalink
            get() = "/workshop/$name"
    }

    val workshop = Workshop(name = "G")

    val event = workshop.makeEvent(date)
    val permalink = workshop.permalink

    val makeEventRef = Workshop::makeEvent
    val permalinkPropRef = Workshop::permalink
}

class Workshop(val name : String)
fun Workshop.makeEvent(date: DateTime): Event = Event()
val Workshop.permalink
    get() = "/workshop/$name"

fun useWorkshop(workshop: Workshop){
    val event = workshop.makeEvent(date)
    val permalink = workshop.permalink

    val makeEventRef = Workshop::makeEvent
    val permalinkPropRef = Workshop::permalink
}

fun test2() {
    open class C
    class D : C()

    fun C.foo() = "c"
    fun D.foo() = "d"

    val d = D()
    println(d.foo())
    val c: C = d
    println(c.foo())

    println(D().foo())
    println((D() as C).foo())

    "".isNullOrBlank()
}

//inline fun CharSequence?.isNullOrBlank(): Boolean {
//    contract {
//        returns(false) implies (this@isNullOrBlank != null)
//    }
//    return this == null || this.isBlank()
//}

public fun Iterable<Int>.sum(): Int {
    var sum: Int = 0
    for (element in this) {
        sum += element
    }
    return sum
}

suspend fun main() = runBlocking{
    test2()
}