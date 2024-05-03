package _7_46_inline

import kotlinx.coroutines.runBlocking

inline fun <reified T> printTypeName(){
    print(T::class.simpleName)
}

fun test1(){
    val any = listOf<String>()

//    any is List<Int>
//    any is List<*>

    printTypeName<Int>()
    printTypeName<Char>()
    printTypeName<String>()

    class Worker
    class Manager

    val employees: List<Any> =
        listOf(Worker(), Manager(), Worker())
    val workers: List<Worker> =
        employees.filterIsInstance<Worker>()
}

inline fun printTree(){

}

val lambda: () -> Unit = {
    //
}

inline fun repeat(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

fun repeatNoinline(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

fun test2(){
    data class User(val bought : Boolean, val price: Double)
    val users = listOf<User>()
    users.filter { it.bought }.sumOf { it.price }

    var l = 1L
    noninlineRepeat(100_000_000) {
        l += it
    }
}

fun noninlineRepeat(n: Int, lambda: (Int)-> Unit){

}

fun repeatNoninline(n: Int, lambda: (Int)-> Unit){

}

fun test3(){
    val value : Int? = null
    if (value != null){
        print(value)
        return
    }

    for(i in 1..10){
        print(i)
        return
    }

    repeatNoninline(10){
        print(it)
//        return
    }

    repeat(10){
        print(it)
        return
    }
}
class Money

fun searchForMoney() = Money()

fun getSomeMoney(): Money? {
    repeat(100){
        val money = searchForMoney()
        if(money != null) return money
    }
    return null
}

internal inline fun read(){
//    val reader = Reader()
}

private class Reader {

}

inline fun printThree(){
    print(3)
}

inline fun threePrintThree(){
    printThree()
    printThree()
    printThree()
}

inline fun threeThreePrintThree(){
    threePrintThree()
    threePrintThree()
    threePrintThree()
}

inline fun threeThreeThreePrintThree(){
    threeThreePrintThree()
    threeThreePrintThree()
    threeThreePrintThree()
}


inline fun requestNewToken(
    hasToken: Boolean,
    crossinline onRefresh: () -> Unit,
    noinline onGenerate: () -> Unit
){
    if(hasToken) {
        httpCall("get-token", onGenerate)
    }else{
        httpCall("refresh-token") {
            onRefresh()
            onGenerate()
        }
    }
}

fun httpCall(url: String, callback: () -> Unit){

}

suspend fun main() = runBlocking{
    test3()
}