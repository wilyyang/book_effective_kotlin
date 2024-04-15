package _5_33_FactoryFunc

import _1_8_null.Intent
import _4_27_abstractin.Context
import kotlinx.coroutines.runBlocking

open class MyLinkedList<T>(
    val head: T,
    val tail: MyLinkedList<T>?
) {
    companion object {
        fun <T> of(vararg elements: T): MyLinkedList<T>? {
            TODO()
        }
    }
}

interface MyList<T> {
    companion object {
        fun <T> of(vararg elements: T): MyList<T>? {
            TODO()
        }
    }
}

open class Activity : Context()
open class AppCompatActivity : Activity()
abstract class ActivityFactory {
    abstract fun getIntent(context: Context) : Intent

    fun start(context: Context){
        val intent = getIntent(context)
        context.startActivity(intent)
    }

    fun startForResult(activity: Activity, requestCode: Int){
        val intent = getIntent(activity)
        activity.startActivityForResult(intent, requestCode)
    }
}

fun <T : Activity> intentFor(vararg pair: Pair<String, Int>) : Intent{ TODO() }
class MainActivity : AppCompatActivity(){
    companion object: ActivityFactory(){
        override fun getIntent(context: Context): Intent {
            val intent = intentFor<MainActivity>()
            return intentFor<MainActivity>("page" to 2, "row" to 10)
        }

    }
}

interface Tool {
    companion object { }
}

class BigTool
fun Tool.Companion.createBigTool() : BigTool {
    TODO()
}

class A

class Tree<T> {
    companion object {
        operator fun <T> invoke(size: Int, generator: (Int)->T) : Tree<T>{
            TODO()
        }
    }
}

data class Student(
    val id: Int,
    val name : String,
    val surname: String
)

class StudentsFactory{
    var nextId = 0
    fun next(name: String, surname: String) =
            Student(nextId++, name, surname)
}

fun test1(){
    val list = MyLinkedList.of(1, 2)
    val list2 = MyList.of(1,2)

    val context = Context()
    val activity = Activity()
    val requestCode = 2
    val intent = MainActivity.getIntent(context)
    MainActivity.start(context)
    MainActivity.startForResult(activity, requestCode)

    Tool.createBigTool()

    val a = A()

    val reference: ()->A = ::A

    List(4) { "User$it"}
//    Tree(10){ "$it"}
//    Tree.invoke(10){ "$it"}

    val f1: ()->Tree<String> = ::Tree
    val f2: ()->Tree<String> = ::Tree
//    val f3: ()->Tree<String> = Tree.Companion::invoke

    val factory = StudentsFactory()
    val s1 = factory.next("Marcin", "Moskala")
    println(s1)
    val s2 = factory.next("Igor", "Wojda")
    println(s2)
}


val list = MyLinkedList(1, MyLinkedList(2, null))

fun <T> myLinkedListOf(
    vararg elements: T
): MyLinkedList<T>? {
    if(elements.isEmpty()) return null
    val head = elements.first()
    val elementsTail = elements
        .copyOfRange(1, elements.size)
    val tail = myLinkedListOf(*elementsTail)
    return MyLinkedList(head, tail)
}

val list2 = myLinkedListOf(1,2)

class Config
class ListView(val items : String)
fun makeListView(config : Config) : ListView {
    val items = "..."// config 로부터 요소 읽어들임
    return ListView(items) // 진짜 생성자 호출
}

//class IntLinkedList: MyLinkedList<Int>{
//    constructor(vararg ints: Int): myLinkedListOf(*ints)
//}

class MyLinkedIntList(head: Int, tail: MyLinkedIntList?):
    MyLinkedList<Int>(head, tail)

fun myLinkedListIntListOf(vararg elements: Int): MyLinkedIntList? {
    if(elements.isEmpty()) return null
    val head = elements.first()
    val elementsTail = elements
        .copyOfRange(1, elements.size)
    val tail = myLinkedListIntListOf(*elementsTail)
    return MyLinkedIntList(head, tail)
}

suspend fun main() = runBlocking{
    test1()
}