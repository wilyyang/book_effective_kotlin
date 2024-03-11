package _1_1_variable

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.*
import kotlin.Comparable
import kotlin.concurrent.thread
import kotlin.properties.Delegates

class BankAccount {
    var balance = 0.0
        private set

    fun deposit(depositAmount: Double) {
        balance += depositAmount
    }

    @Throws(InsufficientFunds::class)
    fun withdraw(withdrawAmount : Double){
        if(balance < withdrawAmount){
            throw InsufficientFunds()
        }
        balance -= withdrawAmount
    }
}
class InsufficientFunds : Exception()

fun test1(){
    val account = BankAccount()
    println(account.balance)
    account.deposit(100.0)
    println(account.balance)
    account.withdraw(50.0)
    println(account.balance)
}

fun test2(){
    var num = 0
    for(i in 1..10000){
        thread {
            Thread.sleep(10)
            num += 1
        }
    }
    Thread.sleep(5000)
    print(num)
}

suspend fun test3(){
    var num = 0

    coroutineScope {
        for(i in 1..10000){
            launch {
                delay(100)
                num+=1
            }
        }
    }
    print(num)
}

suspend fun test4(){
    val lock = Any()
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            synchronized(lock){
                num+=1
            }
        }
    }
    Thread.sleep(1000)
    print(num)
}

//var name: String = "Marcin"
//var surname: String = "Moskala"
//val fullName
//    get() = "$name $surname"

fun test5(){
    println(fullName)
//    name = "Maja"
    println(fullName)
}

fun calculate(): Int {
    println("Calulating...")
    return 42
}

//val fizz = calculate()
val buzz
    get() = calculate()

fun test6(){
//    println(fizz)
//    println(fizz)
    println(buzz)
    println(buzz)
}

interface Element {
    val active : Boolean
}

class ActualElement : Element {
    override var active: Boolean = false
}

val name : String? = "Marton"
val surname: String = "Braun"

val fullName: String?
    get() = name?.let { "$it $surname"}

val fullName2: String? = name?.let { "$it $surname"}

fun test7(){
    if(fullName != null){
        println(fullName!!.length)
    }

    if(fullName2 != null){
        println(fullName2.length)
    }
}

fun test8(){
    val list = listOf(1,2,3)
//    if(list is MutableList){
//        list.add(4)
//    }

    val mutableList = list.toMutableList()
    mutableList.add(4)
}

data class FullName(var name : String, val surName : String): Comparable<FullName> {

    override fun compareTo(other: FullName): Int {
        return this.surName.compareTo(other.surName)
    }
}
fun test9(){
    val names: SortedSet<FullName> = TreeSet()
    val person = FullName("AAA", "AAA")
    names.add(person)
    names.add(FullName("Jordan", "Hansen"))
    names.add(FullName("David", "Blanc"))

    println(names)
    println(person in names)

    person.name = "ZZZ"
    println(names)
    println(person in names)
}

val list1 : MutableList<Int> = mutableListOf()
var list2 = listOf<Int>()
    private set
fun test10() {
    for (i in 1..2000) {
        thread { list1 += i }
    }

    for (i in 1..2000) {
        thread { list2 = list2 + i }
    }
    Thread.sleep(2000)

    println(list1.size)
    println(list2.size)
}

data class Announcement(var name : String)
var announcements = listOf<Announcement>()
    private set

fun test11() {
    var names by Delegates.observable(listOf<String>()){ _, old, new ->
        println("Names changed from $old to $new")
    }
    names += "Fabio"
    names += "Bill"
}

data class User(val name: String)
class UserRepository {
    private val storedUsers: MutableMap<Int, String> =
        mutableMapOf()

    fun loadAll(): MutableMap<Int, String>{
        return storedUsers
    }

}

fun test12() {
    val userRepository = UserRepository()
    val storedUsers = userRepository.loadAll()
    storedUsers[4] = "Kirill"

    print(userRepository.loadAll())
}

data class MutableUser (private val name : String = "")
class UserHolder {
    private val user = MutableUser()
    fun get(): MutableUser {
        return user.copy()
    }
}

suspend fun main() = runBlocking{
    test12()
}