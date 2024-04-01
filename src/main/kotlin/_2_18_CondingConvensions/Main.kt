package _2_18_CondingConvensions

import kotlinx.coroutines.runBlocking

class FullName(val name : String, val surname: String)

open class Human(open val id: Int, open val name : String)

class Person(
    override val id : Int = 0,
    override val name : String = "",
    val surname : String = ""
) : Human(id, name){

    public fun <T> Iterable<T>.joinToString(
        separator: CharSequence = ", ",
        prefix: CharSequence = "",
        postfix: CharSequence = "",
        limit: Int = -1,
        truncated: CharSequence = "...",
        transform: ((T) -> CharSequence)? = null
    ): String {
        return ""
    }
}

class Person2(override val id: Int = 0,
    override val name : String = "",
    val surname: String = "") : Human(id, name){

    }


fun test1(){


}

suspend fun main() = runBlocking{
    test1()
}