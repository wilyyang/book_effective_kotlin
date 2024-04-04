package _3_23

import kotlinx.coroutines.runBlocking

//class Forest(val name : String){
//    fun addTree(name : String){
//
//    }
//}

interface Tree
open class Birch : Tree
class Spruce : Tree
class QQQ : Tree

class BirchChild : Birch()
class Forest<T: Tree>{
    fun  <ST: T>addTree(tree: ST){
        println(tree.javaClass.name)
    }
}

fun test1(){
    val forest = Forest<Birch>()
    forest.addTree(BirchChild())
//    forest.addTree(Spruce())
//    forest.addTree(QQQ())
}

suspend fun main() = runBlocking{
    test1()
}