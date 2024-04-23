package _6_37

import kotlinx.coroutines.runBlocking
import java.awt.Color

data class Player(
    val id : Int,
    val name : String,
    val points: Int
)


fun test1(){
    val player = Player(0, "Gecko", 9999)
    println(player)
    println(player == Player(0, "Gecko", 9999))
    println(player == Player(0, "Ross", 9999))

    val newObj = player.copy(name = "Thor")
    println(newObj)

    val (id, nam, pts) = player
    val visited = listOf("China", "Russia", "India")
    val (first, second, third) = visited
    println("$first $second $third")

    val trip = mapOf(
        "China" to "Tianjin",
        "Russia" to "PetersBurg",
        "India" to "Rishikesh"
    )

    for((country, city) in trip){
        println("We loved $city in $country")
    }

    data class FullName(
        val firstName: String,
        val secondName : String,
        val lastName : String
    )

    val elon = FullName("Elon", "Reeve", "Musk")
    val (firstName, _, lastName) = elon
    println("It is $firstName $lastName!")

    data class User(val name : String)
    val user = User("John")
    user.let { a -> println(a) }
    user.let { (a) -> println(a)}

    val degree = 14
    val (description, color) = when {
        degree < 5 -> "cold" to Color.BLUE
        degree < 23 -> "mild" to Color.YELLOW
        else -> "hot" to Color.RED
    }

    val numbers = listOf(3, 5, 7)
    val (odd, even) = numbers.partition { it % 2 == 1 }
    val map = mapOf(1 to "San Francisco", 2 to "Amsterdam")

    val fullName = "Marcin Moskala"
    val (firstName2, lastName2) = fullName.parseName() ?: return
    println("$firstName2 $lastName2")

    val (lastName3, firstName3) = fullName.parseName() ?: return
    println("His name is $firstName3 $lastName3")

}

fun String.parseName(): Pair<String, String>? {
    val indexOfLastSpace = this.trim().lastIndexOf(' ')
    if(indexOfLastSpace < 0) return null
    val firstName = this.take(indexOfLastSpace)
    val lastName = this.drop(indexOfLastSpace+1)
    return Pair(firstName, lastName)
}

suspend fun test2(){
    data class FullName(
        val firstName: String,
        val lastName: String
    )

    fun String.parseName(): FullName? {
        val indexOfLastSpace = this.trim().lastIndexOf(' ')
        if(indexOfLastSpace < 0) return null
        val firstName = this.take(indexOfLastSpace)
        val lastName = this.drop(indexOfLastSpace+1)
        return FullName(firstName, lastName)
    }

    val fullName = "Marcin Moskala"
    val (firstName, lastName) = fullName.parseName() ?: return
    println("His name is $firstName $lastName")

}

suspend fun main() = runBlocking{
    test2()
}