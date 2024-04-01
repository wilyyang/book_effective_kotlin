package _2_17_NamedArgument

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.Date
import kotlin.concurrent.thread


fun test1(){
    val separator = "|"
    val text = (1..10).joinToString(separator = separator)
}


fun sendEmail(to: String, message: String){}
suspend fun test2() = coroutineScope {
    delay(timeMillis = 100)

//    Thread.sleep(time = Millis(100))
//    Thread.sleep(time = 100.ms)

    sendEmail(to = "contact@kt.academy", message = "Hello, ...")
    thread {

    }

//    val view = linearLayout {
//        text("click below")
//        button(onClick = {/* 1 */}) {
//            /* 2 */
//        }
//    }
}

fun call(before:() -> Unit = {}, after:() -> Unit = {}){
    before()
    print("Middle")
    after()
}

fun test3(){
    call(before = { print("CALL")})
    call(after = { print("CALL")})
//    call{ print("CALL")}
}

suspend fun main() = runBlocking{
    test3()
}