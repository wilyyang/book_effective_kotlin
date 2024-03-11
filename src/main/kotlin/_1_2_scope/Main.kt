package _1_2_scope

import _1_1_variable.User
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.Comparable
import kotlin.concurrent.thread
import kotlin.properties.Delegates

data class User(val name : String)
fun test1(){
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

    val user4 : User

}


suspend fun main() = runBlocking{
    test1()
}