package _3_19_knowledge

import kotlinx.coroutines.runBlocking

class Student{
    fun isPassing() : Boolean = calculatePointsFromPassedCourses() > 15

//    fun qualifiesForScholarship(): Boolean = calculatePointsFromPassedCourses() > 30


    private fun calculatePointsFromPassedCourses() : Int { return 0 }
}

fun Student.qualifiesForScholarship() : Boolean { return false}

fun Student.calculatePointsFromPassedCourses() : Boolean { return false}

fun test1(){


}

suspend fun main() = runBlocking{
    test1()
}