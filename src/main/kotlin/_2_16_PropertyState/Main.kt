package _2_16_PropertyState

import kotlinx.coroutines.runBlocking
import java.util.Date

class Test {
    var name : String? = null
        get() = field?.toUpperCase()
        set(value){
            if(!value.isNullOrBlank()){
                field = value
            }
        }

    val surname = "surname"

    val fullName: String
        get() = "$name $surname"

    private var millis : Long = 0L
    var date: Date
        get() = Date(millis)
        set(value) {
            millis = value.time
        }

    interface Person {
        val name : String
    }

    open class Supercomputer {
        open val theAnswer: Long = 42
    }

    class AppleComputer : Supercomputer(){
        override val theAnswer: Long = 1_800_275_2273
    }

    interface Database
    val db: Database by lazy { connectToDb() }

    class SpecificDatabase : Database
    fun connectToDb(): Database = SpecificDatabase()

//    val Tree<Int>.sum: Int
//        get() = when(this){
//            is Leaf -> value
//            is Node -> left.sum + right.sum
//        }

//    fun Tree<Int>.sum(): Int = when(this){
//        is Leaf -> value
//        is Node -> left.sum + right.sum
//    }

    val s = (1..100).sum()
}

//class UserIncorrect {
//    private var name : String = ""
//
//    fun getName() = name
//    fun setName(name:String){
//        this.name = name
//    }
//}

class UserCorrect {
    var name : String = ""
}

fun test1(){

}


fun test2(){

}

suspend fun main() = runBlocking{
    test1()
}