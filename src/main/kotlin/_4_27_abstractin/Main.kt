package _4_27_abstractin

import kotlinx.coroutines.runBlocking

class Context
class Toast {
    enum class Length{ SHORT, LONG }

    companion object{
        fun makeText(context: Context, message : String, duration: Toast.Length) = Toast()
    }
    fun show(){}
}

interface MessageDisplay {
    fun show(
        message: String,
        duration: MessageLength = MessageLength.LONG
    )
}

class ToastDisplay(val context : Context): MessageDisplay {

    override fun show(
        message: String,
        duration: MessageLength
    ) {
        val toastDuration = when(duration){
            MessageLength.SHORT -> Toast.Length.SHORT
            MessageLength.LONG -> Toast.Length.LONG
        }
        Toast.makeText(context, message, toastDuration).show()
    }
}

enum class MessageLength { SHORT, LONG }

fun test1(){

}


suspend fun main() = runBlocking{
    test1()
}