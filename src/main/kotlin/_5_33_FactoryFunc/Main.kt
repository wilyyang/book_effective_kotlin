package _5_33_FactoryFunc

import kotlinx.coroutines.runBlocking

open class MyLinkedList<T>(
    val head: T,
    val tail: MyLinkedList<T>?
)

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

fun test1(){

}

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