package _8_50_limit_step

import kotlinx.coroutines.runBlocking

open class Student(val name: String?)
class Junior : Student(name = "")

fun List<Student>.getNames1(): List<String> = this
    .map { it.name }
    .filter { it != null }
    .map { it!! }

fun List<Student>.getNames2(): List<String> = this
    .map { it.name }
    .filterNotNull()

fun List<Student>.getNames3(): List<String> = this
    .mapNotNull { it.name }

//fun List<Student>.getNames4() = this
//    .map { it.name }
//    .joinToString()
fun List<Student>.getNames4() = this.joinToString { it.name?:"" }

//fun List<Student>.getNames5() = this.filter { it.name != null }.filter { it.name!!.length > 3 }
fun List<Student>.getNames5() = this.filter { it.name != null && it.name.length > 3 }

//fun List<Student>.getNames6() = this.filter { it is Junior }.map { it as Junior }
fun List<Student>.getNames6() = this.filterIsInstance<Junior>()

//fun List<Student>.getNames7() = this.sortedBy { it.name }.sortedBy { it.name!!.length }
fun List<Student>.getNames7() = this.sortedWith(compareBy({ it.name }, { it.name!!.length }))

//fun List<Student>.getNames8() = listOf<String?>(null, "", null).filterNotNull()
fun List<Student>.getNames8() = listOfNotNull(null, "", null)

//fun List<Student>.getNames9() = this.withIndex()
//    .filter { (index, elem) -> index > 3 }
//    .map { it.value }

fun List<Student>.getNames9() = this
    .filterIndexed { index, elem -> index > 3 }

fun test1(){

}

suspend fun main() = runBlocking{
    test1()
}