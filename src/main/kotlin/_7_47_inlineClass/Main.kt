package _7_47_inlineClass

import _5_33_FactoryFunc.Student
import kotlinx.coroutines.runBlocking

@JvmInline
value class Name(private val value: String){

    fun greet() {
        print("Hello, I am $value")
    }
}

fun test1(){
    //    val name: String = "Marcin"
    val name: Name = Name("Marcin")
    //    Name.'greet-impl'(name)
    name.greet()
}

@JvmInline
value class Minutes(val minutes: Int){
    fun toMillis(): Millis = Millis(minutes * 60 * 1000)
}

@JvmInline
value class Millis(val milliseconds: Int){

}

interface User {
    fun decideAboutTime(): Minutes
    fun wakeUp()
}

interface Timer {
    fun callAfter(timeMillis: Millis, callback: () -> Unit)
}

fun setUpUserWakeUpUser(user: User, timer: Timer){
    val time: Minutes = user.decideAboutTime()
    timer.callAfter(time.toMillis()){
        user.wakeUp()
    }
}

val Int.min get() = Minutes(this)
val Int.ms get() = Millis(this)
val timeMin: Minutes = 10.min
val timeMs: Millis = 10.ms

annotation class Entity(val tableName: String)
annotation class ColumnInfo(val name: String)

@JvmInline
value class StudentId(val studentId: Int)
@JvmInline
value class TeacherId(val teacherId: Int)
@JvmInline
value class SchoolId(val schoolId: Int)

@Entity(tableName = "grades")
class Grades(
    @ColumnInfo(name = "studentId")
    val studentId: StudentId,
    @ColumnInfo(name = "teacherId")
    val teacherId: TeacherId,
    @ColumnInfo(name = "schoolId")
    val schoolId: SchoolId
)

interface TimeUnit {
    val millis: Long
}

@JvmInline
value class Minutes2(val minutes: Long): TimeUnit {
    override val millis: Long
        get() = minutes * 60 * 1000
}

@JvmInline
value class Millis2(val milliseconds: Long): TimeUnit {
    override val millis: Long
        get() = milliseconds
}

fun setUpTimer(time: TimeUnit) {
    val millis = time.millis
}

fun test3(){
    setUpTimer(Minutes2(123))
    setUpTimer(Millis2(456789))
}

typealias NewName = Int
val n : NewName = 10

class Event
typealias ClickListener =
        (view: View, event: Event) -> Unit

class View {
    fun addClickListener(listener: ClickListener) {}
    fun removeClickListener(listener: ClickListener){}
}

typealias SecondsType = Int
typealias MillisType = Int

fun getTime(): MillisType = 10
fun setUpTimer(time: SecondsType) {}

fun test4(){
    val seconds : SecondsType = 10
    val millis: MillisType = seconds

    setUpTimer(getTime())
}



suspend fun main() = runBlocking{
    test1()
}