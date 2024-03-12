package _1_5_exception_code

import kotlinx.coroutines.runBlocking


fun pop(num:Int = 1): List<T> {
    require(num <= size) {
        "Cannot remove"
    }
}


suspend fun main() = runBlocking{
    test1()
}