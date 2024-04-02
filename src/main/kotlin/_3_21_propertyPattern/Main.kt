package _3_21_propertyPattern

import kotlinx.coroutines.runBlocking
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun createValue() = "GOGO"
fun notifyDataSetChanged() {}

class Item
class Log{
    companion object {
        fun e(s : String){}
    }
}

var items: List<Item> by
Delegates.observable(listOf()) { _, _, _ ->
    notifyDataSetChanged()
}
val value by lazy { createValue() }
var key: String? by
Delegates.observable(null) { _, old, new ->
    Log.e("key changed from $old to $new")
}

class Test1(){
    var token: String? = null
        get(){
            print("token returned value $field")
            return field
        }
        set(value) {
            print("token changed from $field to $value")
            field = value
        }

    var attempts: Int = 0
        get() {
            print("attempts returned value $field")
            return field
        }
        set(value) {
            print("attempts changed from $field to $value")
            field = value
        }
}

private class LoggingProperty<T>(var value: T){
    operator fun getValue(
        thisRef: Any?,
        prop: KProperty<*>
    ): T {
        println("${prop.name} returned value $value")
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        prop: KProperty<*>,
        newValue : T
    ) {
        val name = prop.name
        println("$name changed from $value to $newValue")
        value = newValue
    }
}

fun test1(){
    var token: String? by LoggingProperty(null)
    var attempts: Int by LoggingProperty(0)

    println("$token and $attempts")
    attempts = 4
}

val map : Map<String, Any> = mapOf(
    "name" to "Marcin",
    "kotlinProgrammer" to true
)

fun test2(){
    val name by map
    println(name)

    val kotlinProgrammer by map
    println(kotlinProgrammer)
}


suspend fun main() = runBlocking{
    test2()
}