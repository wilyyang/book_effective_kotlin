package _6_38_UseFuncType

import kotlinx.coroutines.runBlocking
import java.util.*

open class View { var name : String? = null}
fun setOnClickListener(listener: (View) -> Unit){

}

typealias OnClick = (view: View, id : Int)-> Unit

fun test1(){
    setOnClickListener { /*...*/ }
    setOnClickListener(fun(view) { /*...*/ })

    setOnClickListener(::println)

    class UserView : View(){
        fun testView(){
            setOnClickListener(this::showUsers)
        }

        fun showUsers(view: View){}
    }

    class ClickListener: (View)-> Unit {
        override fun invoke(view: View) {
            // ...
        }
    }

    setOnClickListener(ClickListener())

    fun setOnClickListener(listener: OnClick) { /*...*/ }

    setOnClickListener {  view, id ->

    }

}

class CalendarView() {
    var onDateClicked: ((date: Date) -> Unit)? = null
    var onPageChanged: OnDateClicked? = null
}

interface OnDateClicked {
    fun onClick(date: Date)
}

suspend fun main() = runBlocking{
    test1()
}