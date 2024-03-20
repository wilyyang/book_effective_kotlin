package _2_11_target_readability

import kotlinx.coroutines.runBlocking
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.util.zip.ZipInputStream

data class Person(val name : String, val isAdult: Boolean = false)
class View{
    fun showPerson(person: Person){}
    fun showError(){}
    fun hideProgressWithSuccess(){}
    fun hideProgress(){}
}

fun test1(person: Person? = null){
    val view : View = View()

    if(person != null && person.isAdult){
        view.showPerson(person)
    }else{
        view.showError()
    }

    person?.takeIf{ it.isAdult }
        ?.let(view::showPerson)
        ?:view.showError()


    if(person != null && person.isAdult){
        view.showPerson(person)
        view.hideProgressWithSuccess()
    }else{
        view.showError()
        view.hideProgress()
    }

    person?.takeIf{ it.isAdult }
        ?.let{
            view.showPerson(it)
            view.hideProgressWithSuccess()
        }
        ?: run {
            view.showError()
            view.hideProgress()
        }
}

var person: Person? = null

fun printName(){
    person?.let{
        print(it.name)
    }
}

data class SomeObject(val name : String)
data class Student(val name : String, val surname: String, val result : Int)
fun test2(){
    val students = listOf<Student>()
    students
        .filter { it.result >= 50 }
        .joinToString(separator = "\n") {
            "${it.name} ${it.surname}, ${it.result}"
        }
        .let(::print)


    var obj = FileInputStream("/file.gz")
        .let (::BufferedInputStream)
        .let (::ZipInputStream)
        .let (::ObjectInputStream)
        .readObject() as SomeObject

//    ObjectInputStream(ZipInputStream(BufferedInputStream(FileInputStream("/file.gz")))).readObject() as SomeObject
}

operator fun String.invoke(f: () -> String): String = this + f()

infix fun String.and(s : String) = this + s

fun test3(){
    val abc = "A" { "B" } and "C"
    print(abc)
}


suspend fun main() = runBlocking{
    test1()
}