package _5_35_DSL

import kotlinx.coroutines.runBlocking

inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> {
    val list = arrayListOf<T>()
    for(elem in this){
        if(predicate(elem)){
            list.add(elem)
        }
    }
    return list
}

fun plus(a: Int, b: Int) = a + b

val plus1: (Int, Int) -> Int = { a, b -> a + b }
val plus2: (Int, Int) -> Int = fun(a, b) = a + b
val plus3: (Int, Int) -> Int = ::plus
val plus4 = { a: Int, b: Int -> a + b }
val plus5 = fun(a: Int, b: Int) = a + b

fun Int.myPlus(other: Int) = this + other
val myPlus = fun Int.(other: Int) = this + other

val myPlus2: Int.(Int)->Int = fun Int.(other: Int) = this + other
val myPlus3: Int.(Int)->Int = fun Int.(other) = this + other
val myPlus4: Int.(Int)->Int = { this + it }

inline fun <T> T.apply(block: T.() -> Unit): T{
    this.block()
    return this
}

class User{
    var name: String = ""
    var surname: String = ""
}

fun test1(){
    myPlus.invoke(1,2)
    myPlus(1,2)
    1.myPlus(2)

    val user = User().apply {
        name = "Marcin"
        surname = "Moskala"
    }
}

//fun table(init: TableBuilder.() -> Unit): TableBuilder {
//    val tableBuilder = TableBuilder()
//    init.invoke(tableBuilder)
//    return tableBuilder
//}
fun table(init: TableBuilder.() -> Unit) = TableBuilder().apply(init)

//class TableBuilder {
//    fun tr(init: TrBuilder.() -> Unit) {}
//}
//class TrBuilder {
//    fun td(init: TdBuilder.(String) -> Unit) {}
//}

class TableBuilder {
    var trs = listOf<TrBuilder>()
    fun tr(init: TrBuilder.() -> Unit) {
        trs = trs + TrBuilder().apply(init)
    }
}

class TrBuilder {
    var tds = listOf<TdBuilder>()
    fun td(init: TdBuilder.() -> Unit) {
        tds = tds + TdBuilder().apply(init)
    }
}

class TdBuilder {
    var text = ""
    operator fun String.unaryPlus() {
        text += this
    }
}

fun createTable() = table {
    tr {
        for(i in 1..2){
            td {
                +"This is column"
            }
        }
    }
}

suspend fun main() = runBlocking{
    test1()
}