package _7_48_removeRef

import kotlinx.coroutines.runBlocking
import java.util.EmptyStackException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class Stack {
    private var elements: Array<Any?> =
        arrayOfNulls(DEFAULT_INITIAL_CAPACITY)
    private var size = 0

    fun push(e: Any){
        ensureCapacity()
        elements[size++] = e
    }

    fun pop(): Any? {
        if(size == 0){
            throw EmptyStackException()
        }
        val elem = elements[--size]
        elements[size] = null
        return elem
    }

    private fun ensureCapacity(){
        if(elements.size == size){
            elements = elements.copyOf(2 * size + 1)
        }
    }

    companion object {
        private const val DEFAULT_INITIAL_CAPACITY = 16
    }
}

fun <T> mutableLazy(initializer: () -> T):
        ReadWriteProperty<Any?, T> = MutableLazy(initializer)

private class MutableLazy<T>(
    var initializer: (() -> T)?
) : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T {
        synchronized(this) {
            val initializer = initializer
            if(initializer != null){
                value = initializer()
                this.initializer = null
            }
            return value as T
        }
    }

    override fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: T
    ) {
        synchronized(this){
            this.value = value
            this.initializer = null
        }
    }
}

class Game
class Button {
    var listener : (() -> Unit)? = null
    fun setOnClickListener(onClick : () -> Unit){
        listener = onClick
    }
}
val startNewGameButton : Button = Button()
val resumeGameButton : Button = Button()
fun readGameFromSave() : Game = Game()
fun makeNewGame() : Game = Game()
fun startGame() {}

fun test1(){
    var game: Game? by mutableLazy { readGameFromSave() }

    fun setUpActions(){
        startNewGameButton.setOnClickListener {
            game = makeNewGame()
            startGame()
        }
        resumeGameButton.setOnClickListener {
            startGame()
        }
    }
}

suspend fun main() = runBlocking{
    test1()
}