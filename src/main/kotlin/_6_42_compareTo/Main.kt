package _6_42_compareTo

import kotlinx.coroutines.runBlocking

data class User(
    val name: String,
    val surname: String
) : Comparable<User>{
    companion object {
        val DISPLAY_ORDER = compareBy(User::surname, User::name)
    }

//    override fun compareTo(other: User): Int =
//        compareValues(surname, other.surname)

    override fun compareTo(other: User): Int =
        compareValuesBy(this, other, { it.surname }, { it.name })
}

fun test1(){
    val obj1 = ""
    val obj2 = ""

    obj1 > obj2
    obj1 < obj2
    obj1 >= obj2
    obj1 <= obj2

    val names = listOf<User>(
        User("CKO", surname = "cPa"),
        User("2bfde", surname = "ag"),
        User("AAFG", surname = "bw34"),
        User("AAFG", surname = "dw34"),
        User("1bfde", surname = "ag"),
        User("3bfde", surname = "ag")
    )

//    val sorted = names.sortedBy { it.surname }
//    println(sorted)

//    val sorted2 = names.sortedWith(compareBy({it.surname}, {it.name}))
//    println(sorted2)
//
//    println("Kotlin" > "Java")
//
    val sorted3 = names.sortedWith(User.DISPLAY_ORDER)
    println(sorted3)
    println(User("5", "h") > User("hr", "bedgr"))
}



suspend fun main() = runBlocking{
    test1()
}