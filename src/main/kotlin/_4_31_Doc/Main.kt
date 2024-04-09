package _4_31_Doc

import _4_27_abstractin.Context
import _4_27_abstractin.MessageLength
import _4_27_abstractin.Toast
import kotlinx.coroutines.runBlocking

/**
 * Universal way for the project to display a short
 * message to a user.
 * @param message The text that should be shown to
 * the user
 * @param length How long to display the message.
 */
/**
 * 이 프로젝트에서 짧은 메시지를 사용자에게
 * 출력할 때 사용하는 기본적인 방식입니다.
 * @param message 사용자에게 보여 줄 메시지
 * @param length 메시지의길이가
 * 어느 정도 되는지 나타내는 enum 값
 */
fun Context.showMessage(
    message: String,
    length: MessageLength = MessageLength.LONG
){
    val toastLength = when(length){
        MessageLength.SHORT -> Toast.Length.SHORT
        MessageLength.LONG -> Toast.Length.LONG
    }
    Toast.makeText(this, message, toastLength).show()
}

/**
 * Powerset returns a set of all subsets of the receiver
 * including itself and the empty set
 */
/**
 * 리시버 집합의 모든 부분 집합을 리턴합니다.
 * (자기 자신과 빈 집합을 포함합니다.)
 */
fun <T> Collection<T>.powerset(): Set<Set<T>> =
    if (isEmpty()) setOf(emptySet())
    else take(size - 1).powerset().let { it + it.map { it + last() } }


private tailrec fun <T> powerset(
    left: Collection<T>,
    acc: Set<Set<T>>
): Set<Set<T>> = when {
    left.isEmpty() -> acc
    else -> {
        val head = left.first()
        val tail = left.drop(1)
        powerset(tail, acc + acc.map { it + head })
    }
}

fun test1(){

}

suspend fun main() = runBlocking{
    test1()
}