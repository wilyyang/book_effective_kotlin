package _6_44_memberExtension

import kotlinx.coroutines.runBlocking



interface PhoneBook {
    fun String.isPhoneNumber() : Boolean
}

class Fizz: PhoneBook {
    override fun String.isPhoneNumber(): Boolean =
        length == 7 && all { it.isDigit() }
}

class PhoneBookIncorrect {
//    fun String.isPhoneNumber() =
//        length == 7 && all { it.isDigit() }
}
private fun String.isPhoneNumber() : Boolean =
    length == 7 && all { it.isDigit() }


fun test2() {
//    PhoneBookIncorrect().apply {
//        "1234567890".isPhoneNumber()
//    }

    val ref = String::isPhoneNumber
    val str = "1234567890"
    val boundedRef = str::isPhoneNumber

//    val refX = PhoneBookIncorrect::isPhoneNumber
//    val book = PhoneBookIncorrect()
//    val boundedRefX = book::isPhoneNumber

}

class A{
    val a = 10
}

class B{
    val a = 20
    val b = 30

    fun A.test() = a+b

    fun A.update(){}
}




suspend fun main() = runBlocking{
    test2()
}