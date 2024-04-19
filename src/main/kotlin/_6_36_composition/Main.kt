package _6_36_composition

import kotlinx.coroutines.runBlocking

abstract class LoaderWithProgress{
    open fun load(){
        innerLoad()
    }

    abstract fun innerLoad()
}

//class ProfileLoader : LoaderWithProgress() {
//    override fun load(){
//        innerLoad()
//    }
//
//    override fun innerLoad() {
//        TODO("Not yet implemented")
//    }
//}
//
//class ImageLoader : LoaderWithProgress() {
//    override fun load(){
//        innerLoad()
//    }
//
//    override fun innerLoad() {
//        TODO("Not yet implemented")
//    }
//}

class Progress {
    fun showProgress() { }
    fun hideProgress() { }
}

class FinishedAlert(){
    fun show() { }
}

//class ProfileLoader {
//    private val progress = Progress()
//
//    fun load(){
//        progress.showProgress()
//        // 프로파일을 읽어 들임
//        progress.hideProgress()
//    }
//}
//
//class ImageLoader {
//    private val progress = Progress()
//    private val finishedAlert = FinishedAlert()
//
//    fun load(){
//        progress.showProgress()
//        // 이미지를 읽어 들임
//        progress.hideProgress()
//        finishedAlert.show()
//    }
//}

abstract class InternetLoader(val showAlert: Boolean){
    fun load(){
        // 프로그레스 바를 보여 줌
        innerLoad()
        // 프로그레스 바를 숨김
        if(showAlert){
            // 경고창 출력
        }
    }

    abstract fun innerLoad()
}

class ProfileLoader : InternetLoader(showAlert = true){
    override fun innerLoad() {
        // 프로파일을 읽어 들임
    }
}

class ImageLoader : InternetLoader(showAlert = false){
    override fun innerLoad() {
        // 이미지를 읽어 들임
    }
}

abstract class Dog {
    open fun bark() { }
    open fun sniff() { }
}

class Labrador: Dog()
class RobotDog: Dog(){
    override fun sniff() {
        throw error("Operation not supported")
    }
}

//class CounterSet<T>: HashSet<T>() {
//    var elementsAdded: Int = 0
//        private set
//
//    override fun add(element: T): Boolean {
//        elementsAdded++
//        return super.add(element)
//    }
//
////    override fun addAll(elements: Collection<T>): Boolean {
////        elementsAdded += elements.size
////        return super.addAll(elements)
////    }
//}


//class CounterSet<T> {
//   private val innerSet = HashSet<T>()
//    var elementsAdded: Int = 0
//        private set
//
//    fun add(element: T){
//        elementsAdded++
//        innerSet.add(element)
//    }
//
//    fun addAll(elements: Collection<T>){
//        elementsAdded += elements.size
//        innerSet.addAll(elements)
//    }
//}

//class CounterSet<T> : MutableSet<T> {
//    private val innerSet = HashSet<T>()
//    var elementsAdded: Int = 0
//        private set
//    override fun add(element: T): Boolean {
//        elementsAdded++
//        return innerSet.add(element)
//    }
//
//    override fun addAll(elements: Collection<T>): Boolean {
//        elementsAdded += elements.size
//        return innerSet.addAll(elements)
//    }
//
//    override val size: Int
//        get() = innerSet.size
//
//    override fun contains(element: T): Boolean =
//        innerSet.contains(element)
//
//    override fun containsAll(elements: Collection<T>): Boolean =
//        innerSet.containsAll(elements)
//
//    override fun isEmpty(): Boolean = innerSet.isEmpty()
//
//    override fun iterator() = innerSet.iterator()
//
//    override fun clear() = innerSet.clear()
//
//    override fun remove(element: T): Boolean =
//        innerSet.remove(element)
//
//    override fun removeAll(elements: Collection<T>): Boolean =
//        innerSet.removeAll(elements)
//    override fun retainAll(elements: Collection<T>): Boolean =
//        innerSet.retainAll(elements)
//}

class CounterSet<T>(
    private val innerSet: MutableSet<T> = mutableSetOf()
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

open class Parent {
    fun a() {}
    open fun b() {}
}

class Child: Parent(){
//    override fun a() {}
    override fun b() {}
}

open class InternetLoader2{
    open fun loadFromInternet() {}
}
open class ProfileLoader2 : InternetLoader2(){
    final override fun loadFromInternet() {}
}

class TestPPP : ProfileLoader2(){
//    override fun loadFromInternet() { }
}

fun test1(){
    val counterList = CounterSet<String>()
    counterList.addAll(listOf("A", "B", "C"))
    print(counterList.elementsAdded)
}

suspend fun main() = runBlocking{
    test1()
}