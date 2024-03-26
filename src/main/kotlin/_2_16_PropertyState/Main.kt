package _2_16_PropertyState

import kotlinx.coroutines.runBlocking

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
}

fun test1(){

}


fun test2(){

}



suspend fun main() = runBlocking{
    test1()
}