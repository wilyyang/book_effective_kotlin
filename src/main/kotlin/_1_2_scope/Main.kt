package _1_2_scope

import kotlinx.coroutines.runBlocking
import java.awt.Color

fun test1(){
    data class User(val name : String = "")
    val a = 1
    fun fizz() {
        val b = 2
        print(a+b)
    }
    val buzz = {
        val c = 3
        print(a+c)
    }

    val users = listOf(User("ydg"))
    var user: User
    for(i in users.indices){
        user = users[i]
        println("User at $i is $user")
    }

    for(i in users.indices){
        val user2 = users[i]
        println("User at $i is $user2")
    }

    for ((i, user3) in users.withIndex()){
        println("User at $i is $user3")
    }

    fun getValue() = User(name = "has")
    val hasValue = true
    val user4 : User
    if(hasValue){
        user4 = getValue()
    }else {
        user4 = User()
    }

    val user5: User = if(hasValue) {
        getValue()
    }else {
        User()
    }
}

fun updateWeather(degrees: Int){
    val description: String
    val color: Int
    if(degrees < 5) {
        description = "cold"
        color = Color.BLUE.rgb
    }else if(degrees < 23) {
        description = "mild"
        color = Color.YELLOW.rgb
    }else {
        description = "hot"
        color = Color.RED.rgb
    }
}

fun updateWeather2(degrees : Int){
    val (description, color) = when {
        degrees < 5 -> "cold" to Color.BLUE.rgb
        degrees < 23 -> "mild" to Color.YELLOW.rgb
        else -> "hot" to Color.RED.rgb
    }
}

fun test2(){
    var numbers = (2..100).toList()
    val primes = mutableListOf<Int>()
    while(numbers.isNotEmpty()){
        val prime = numbers.first()
        primes.add(prime)
        numbers = numbers.filter { it % prime != 0}
    }
    print(primes)
}

fun test3(){
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it+1 }

        while(true){
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1)
                .filter { it % prime != 0 }
        }
    }
    print(primes.take(10).toList())
}

fun test4(){
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it+1 }

        var prime : Int
        while(true){
            prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1)
                .filter { it % prime != 0 }
        }
    }
    print(primes.take(10).toList())
}


suspend fun main() = runBlocking{
    test4()
}