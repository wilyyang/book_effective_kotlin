package _5_34_optionArg

import kotlinx.coroutines.runBlocking

data class Student(
    val name : String,
    val surname : String,
    val age : Int
)


fun test1(){

}

suspend fun main() = runBlocking{
    test1()
}