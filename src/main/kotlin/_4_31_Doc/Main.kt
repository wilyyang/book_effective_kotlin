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

/**
 * @constructor
 * @property name
 */
class TestQ (val name : String){

    private val users : List<String> = listOf()
    private val books : List<String> = listOf()
    fun update(){
        updateUsers()
        updateBooks()
    }

    private fun updateBooks(){
        for (book in books){
            updateBook()
        }
    }

    private fun updateUsers(){
        for (book in users){
            updateUser()
        }
    }

    private fun updateBook(){}
    private fun updateUser(){}

    /**
     * @param arg1 알규먼트
     * @return 결과는 없다
     * @throws IndexOutOfBoundsException
     * @exception IllegalStateException
     *
     * @sample testFunc("fg", "gh")
     * @see powerset
     * @author willy
     * @since 1.0.0
     * @suppress
     */
    private fun testFunc(arg1: String, arg2: String) : String{
        val result : String = ""
        return result
    }

    /**
     * [_3_23.main], [_3_20.test1],
     * [element3에 대한 설명을 입력합니다.][_3_23.main]처럼
     * 작성하면 링크를 만들 수 있습니다.
     */
    /**
     * This is an example description linking to [testGo],
     * [_3_23.main] and
     * [this element with custom description] [param]
     * @receiver
     */
    private fun String.testGo(param : String){

    }
}

/**
 * Immutable tree data structure.
 *
 * Class represents immutable tree having from 1 to
 * infinitive number of elements. In the tree we hold
 * elements on each node and nodes can have left and
 * right subtrees...
 *
 * @param T the type of elements this tree holds.
 * @property value the value kept in this node of the tree.
 * @property left the left subtree.
 * @property right the right subtree.
 */
class Tree<T>(
    val value: T,
    val left : Tree<T>? = null,
    val right : Tree<T>? = null
) {
    /**
     * Creates a new tree based on the current but with
     * [element] added.
     * @return newly created tree with additional element.
     */
    operator fun plus(element: T): Tree<T> {
        TODO()
    }
}


interface Car {
    /**
     * Changed car direction
     *
     * @param angle Represents ...
     */
    fun setWheelPosition(angle : Float)

    /**
     * Decelerates vehicle speed until 0.
     *
     * @param pressure The percentage ...
     */
    fun setBreakPedal(pressure: Double)

    /**
     * Accelerates vehicle speed until max speed possible
     * for user.
     *
     * @param pressure The percentage ...
     */
    fun setGasPedal(pressure: Double)
}
class GasolineCar :Car {
    override fun setWheelPosition(angle: Float) {
        TODO("Not yet implemented")
    }

    override fun setBreakPedal(pressure: Double) {
        TODO("Not yet implemented")
    }

    override fun setGasPedal(pressure: Double) {
        TODO("Not yet implemented")
    }
}

class GasCar : Car {
    override fun setWheelPosition(angle: Float) {
        TODO("Not yet implemented")
    }

    override fun setBreakPedal(pressure: Double) {
        TODO("Not yet implemented")
    }

    override fun setGasPedal(pressure: Double) {
        TODO("Not yet implemented")
    }

}

class ElectricCar : Car {
    override fun setWheelPosition(angle: Float) {
        TODO("Not yet implemented")
    }

    override fun setBreakPedal(pressure: Double) {
        TODO("Not yet implemented")
    }

    override fun setGasPedal(pressure: Double) {
        TODO("Not yet implemented")
    }

}

suspend fun main() = runBlocking{
    test1()
}