package _1_5_exception_code

import kotlinx.coroutines.runBlocking

fun List<String>.pop(num: Int = 1, isOpen: Boolean): List<String> {
    require(num <= size) {
        "Cannot remove more elements than current size"
    }
    check(isOpen) { "Cannot pop from closed stack" }
    val ret = take(num)
    assert(ret.size == num)
    return ret
}

fun factorial(n: Int) : Long {
    require(n >= 0) {
        "Cannot calculate factorial of $n " +
                "because it is smaller than 0"
    }
    return if (n <= 1) 1 else factorial((n-1) * n)
}

data class Point(val x : Long, val y : Long)
data class Cluster(val points : List<Point>)

fun findClusters(points: List<Point>) : List<Cluster>{
    require(points.isNotEmpty())
    return listOf()
}

fun isValidEmail(email: String) = email.isEmpty()

data class User(val email : String)
fun sendEmail(user: User, message: String){
    requireNotNull(user.email)
    require(isValidEmail(user.email))
}

val isInitalized = false
fun speak(text : String){
    check(isInitalized)
}

data class UserInfo(val name : String)
var token :String? = null
fun getUserInfo() : UserInfo{
    checkNotNull(token){
        "OKOKOK"
    }
    return UserInfo(name = "U")
}

val isOpen = false
fun next() {
    check(isOpen)
}

fun pop(num: Int = 1) : List<String> {
    val ret = listOf("PPP", "DDD")
    assert(ret.size == num)
    return ret
}

class Person(val outfit: Outfit, val email: String?, val age : Int? = null)
open class Outfit(val name : String)
class Dress(name : String):Outfit(name = name)

fun changeDress(person : Person){
    require(person.outfit is Dress)
    val dress: Dress = person.outfit
}

fun validateEmail(email: String) { /*...*/ }

fun sendEmail(person: Person, message: String){
    require(person.email != null)
    val email: String = person.email
}
fun sendEmail2(person: Person, text: String){
    val email = requireNotNull(person.email)
    validateEmail(email)
}

fun sendEmail3(person: Person, text: String){
    requireNotNull(person.email)
    validateEmail(person.email)
}

fun sendEmail4(person: Person, text: String){
    val email : String = person.email ?: return
}
fun sendEmail5(person: Person, text: String){
    val email : String = person.email ?: run {
        println("Email not sent, no email address")
        return
    }
}


suspend fun main(): Unit = runBlocking{
//    test1()
    pop(4)
}