package _4_32_abstractionRule

import kotlinx.coroutines.runBlocking

class Employee {
    private val id : Int = 2
    override fun toString() = "User(id=$id)"
    private fun privateFunction(){
        println("Private function called")
    }
}

fun callPrivateFunction(employee: Employee){
    employee::class.java.getDeclaredMethod("privateFunction")
        .apply { isAccessible = true }.invoke(employee)
}

fun changeEmployeeId(employee: Employee, newId: Int){
    employee::class.java.getDeclaredField("id")
        .apply { isAccessible = true }
        .set(employee, newId)
}

fun test1(){
    val employee = Employee()
    callPrivateFunction(employee)
    changeEmployeeId(employee, 1)
    println(employee)
}

class Id(val id : Int){

    override fun hashCode(): Int {
        return id
    }

    override fun equals(other: Any?) =
        other is Id && other.id == id
}

fun test2(){
    val set = mutableSetOf(Id(1))
    set.add(Id(1))
    set.add(Id(2))
    println(set.size)
}

suspend fun main() = runBlocking{
    test2()
}