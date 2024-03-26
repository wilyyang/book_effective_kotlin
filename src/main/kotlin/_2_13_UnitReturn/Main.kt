package _2_13_UnitReturn

import kotlinx.coroutines.runBlocking


fun keyIsCorrect(key:String) : Boolean = false
fun verifyKey(key:String): Unit? = null

fun test1(){
    if(!keyIsCorrect("")) return
    verifyKey("") ?: return
}




suspend fun main() = runBlocking{
    test1()
}