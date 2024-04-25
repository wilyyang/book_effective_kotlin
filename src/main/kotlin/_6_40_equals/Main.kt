package _6_40_equals

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.net.URL
import java.util.*


fun test1(){

    open class Animal
    class Book
//    Animal() == Book()
//    Animal() === Book()

    class Cat: Animal()
    Animal() == Cat()
    Animal() === Cat()

    class Name(val name: String)
    val name1 = Name("Marcin")
    val name2 = Name("Marcin")
    val name1Ref = name1

    name1 == name1
    name1 == name2
    name1 == name1Ref

    name1 === name1
    name1 === name2
    name1 === name1Ref
}

fun test2(){
    data class FullName(val name: String, val surname: String)
    val name1 = FullName("Marcin", "Moskala")
    val name2 = FullName("Marcin", "Moskala")
    val name3 = FullName("Maja", "Moskala")

    println(name1 == name1)
    println(name1 == name2)
    println(name1 == name3)

    println(name1 === name1)
    println(name1 === name2)
    println(name1 === name3)

    class DateTimeClass(
        private var millis: Long = 0L,
        private var timeZone: TimeZone? = null
    ) {
        private var asStringCache = ""
        private var changed = false

        override fun equals(other: Any?): Boolean =
            other is DateTimeClass && other.millis == millis && other.timeZone == timeZone
    }

    data class DateTime(
        private var millis: Long = 0L,
        private var timeZone: TimeZone? = null
    ){
        private var asStringCache = ""
        private var changed = false

    }

    data class TestClass(var name : String = "")
    data class TestData(
        var millis: Long = 0L,
        var test: TestClass? = null
    )

    val data1 = TestData(millis = 3000L, test = TestClass())
    val data2 = TestData(millis = 3000L, test = TestClass())
    println(">>> ${data1 == data2}")

    val data3 = data1.copy()
    println(">>> ${data1 == data3} ${data1.test === data3.test}")

    data3.test?.name = "dsf"
    println(">>> ${data1 == data2}")
    println(">>> ${data1 == data3} ${data1.test === data3.test}")

    val tt : TestData? = null
    tt == null
//    tt.equals(null)
}

fun test3(){
    class User(
        val id: Int,
        val name: String,
        val surname: String
    ) {
        override fun equals(other: Any?): Boolean =
            other is User && other.id == id

        override fun hashCode(): Int = id
    }
}

suspend fun test4(){
    class Time(
        val millisArg: Long = -1,
        val isNow: Boolean = false
    ) {
        val millis: Long get() =
            if(isNow) System.currentTimeMillis()
            else millisArg

        override fun equals(other: Any?): Boolean =
            other is Time && millis == other.millis

    }

    val now = Time(isNow = true)
    println(now == now)
    println(List(100000) { now }.all { it == now })

    val now1 = Time(isNow = true)
    val now2 = Time(isNow = true)
    println(now1 == now2)

}

sealed class Time
data class TimePoint(val millis: Long) : Time()
object Now: Time()
fun test5(){
    class Complex(
        val real: Double,
        val imaginary: Double
    ) {
        override fun equals(other: Any?): Boolean {
            if(other is Double) {
                return imaginary == 0.0 && real == other
            }
            return other is Complex &&
                    real == other.real &&
                    imaginary == other.imaginary
        }
    }

    println(Complex(1.0, 0.0).equals(1.0))
    println(1.0.equals(Complex(1.0, 0.0)))

    val list = listOf<Any>(Complex(1.0, 0.0))
    println(list.contains(1.0))

    val list2 = listOf<Any>(1.0)
    println(list2.contains(Complex(1.0, 0.0)))

    println(Complex(1.0, 0.0).equals(1.0))
//    println(Complex(1.0, 0.0) == 1.0)
}

//open class Date(
//    val year: Int,
//    val month: Int,
//    val day : Int
//){
//    override fun equals(o: Any?) : Boolean = when(o) {
//        is DateTime -> this == o.date
//        is Date -> o.day == day && o.month == month && o.year == year
//        else -> false
//    }
//}
//
//class DateTime(
//    val date: Date,
//    val hour: Int,
//    val minute: Int,
//    val second: Int
//): Date(date.year, date.month, date.day){
//    override fun equals(o: Any?): Boolean = when(o) {
//        is DateTime -> o.date == date && o.hour == hour &&
//                o.minute == minute && o.second == second
//        is Date -> date == o
//        else -> false
//    }
//}

data class Date(
    val year: Int,
    val month: Int,
    val day: Int
)

data class DateTime(
    val date: Date,
    val hour: Int,
    val minute: Int,
    val second: Int
)

fun test6(){
    val o1 = DateTime(Date(1992, 10, 20), 12, 30, 0)
    val o2 = Date(1992, 10, 20)
    val o3 = DateTime(Date(1992, 10, 20), 14, 45, 30)

//    println(o1==o2)
//    println(o2==o3)
//    println(o1==o3)

    println(o1.equals(o2))
    println(o2.equals(o3))
//    println(o1 == o2)

    println(o1.date.equals(o2))
    println(o2.equals(o3.date))
    println(o1.date == o3.date)
}

//open data class Parent(val name: String = "")
//data class Child(val age:Int):Parent()

fun test7(){
    val enWiki = URL("https://en.wikipedia.org/")
    val wiki = URL("https://wikipedia.org/")
    println(enWiki == wiki)
}

suspend fun main() = runBlocking{
    test7()
}