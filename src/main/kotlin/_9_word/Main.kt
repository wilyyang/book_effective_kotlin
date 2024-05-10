package _9_word

import _6_40_equals.Date
import kotlinx.coroutines.runBlocking

fun double(i: Int) = i * 2

class A {

    fun triple(i: Int) = i * 3

    fun twelveTimes(i: Int): Int {
        fun fourTimes() = double(double(i))
        return triple(fourTimes())
    }
}

class IntWrapper(val i : Int) {
    fun doubled(): IntWrapper = IntWrapper(i * 2)
}

fun IntWrapper.tripled() = IntWrapper(i * 3)

fun test1() {
    val double = fun(i: Int) = i * 2
    val triple = { i: Int -> i * 3 }

    val wrapper = IntWrapper(10)

    val doubledWrapper = wrapper.doubled()
    val doubledReference = IntWrapper::doubled

    val tripledWrapper = wrapper.tripled()
    val tripledReference = IntWrapper::tripled

    val doubledWrapper2 = doubledReference(wrapper)
    val tripledWrapper2 = tripledReference(wrapper)

}

class User(
    val name: String,
    val surname: String
) {
    val fullName: String
        get() = "$name $surname"

    fun withSurname(surname: String) =
        User(this.name, surname)
}

val User.officialFullName: String
    get() = "$surname, $name"

fun User.withName(name: String) =
    User(name, this.surname)

fun randomString(length: Int): String {
    return ""
}

inline fun <reified T> printName(){
    print(T::class.simpleName)
}

fun test2(){
    randomString(10)
    printName<String>()
}

class SomeObject(val text: String) {

    constructor(date: Date): this(date.toString())

    init {
        print("Creating object")
    }
}

//class SomeObject @JvmOverloads constructor(
//    val text: String = ""
//){
//    init {
//        print("Creating object")
//    }
//}

suspend fun main() = runBlocking{
    test1()
}