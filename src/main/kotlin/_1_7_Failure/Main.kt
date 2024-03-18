package _1_7_Failure

import _1_5_exception_code.Dress
import _1_5_exception_code.Person
import kotlinx.coroutines.runBlocking

val incorrectSign: Boolean = false
inline fun <reified T> String.readObjectOrNull(): T? {
    if(incorrectSign) {
        return null
    }
    val result : T? = null
    return result
}

inline fun <reified T> String.readObject(lambda:() -> T): Result<T> {
    if(incorrectSign){
        return Failure(JsonParsingException())
    }
    return Success(lambda())
}


sealed class Result<out T>
class Success<out T>(val data: T): Result<T>()
class Failure(val throwable: Throwable):Result<Nothing>()

class JsonParsingException: Exception()

fun test1(userText:String) {
    var age = userText.readObjectOrNull<Person>()?.age ?: -1

    val result = userText.readObject<Person> {
        Person(outfit = Dress(name = ""), email = "")
    }
    age = when(result){
        is Success -> result.data.age!!
        is Failure -> -1
    }
}

suspend fun main() = runBlocking{

}