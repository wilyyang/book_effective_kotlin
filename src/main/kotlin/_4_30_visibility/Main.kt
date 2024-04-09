package _4_30_visibility

import kotlinx.coroutines.runBlocking

class CounterSet<T>(
    private val innerSet: MutableSet<T> = mutableSetOf<T>()
) : MutableSet<T> by innerSet {
    var elementsAdded: Int = 0
        private set

    override fun add(element: T): Boolean {
        elementsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elementsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

//class MutableLazyHolder<T>(val initializer: () -> T){
//    private var value: Any = Any()
//    private var initialized = false
//
//    override fun get(): T {
//        if(!initialized){
//            value = initializer()
//            initialized = true
//        }
//        return value as T
//    }
//
//    override fun setValue(){
//        this.value = value
//        initialized = true
//    }
//}

fun test1(){

}

open class Parent{
    internal open fun test1(){}
}

class Child : Parent(){
//    override protected fun test1(){}
    override fun test1(){}
}


suspend fun main() = runBlocking{
    test1()
}