package _6_36_composition

import kotlinx.coroutines.runBlocking

abstract class LoaderWithProgress{
    open fun load(){
        innerLoad()
    }

    abstract fun innerLoad()
}

class ProfileLoader : LoaderWithProgress() {
    override fun load(){
        innerLoad()
    }

    override fun innerLoad() {
        TODO("Not yet implemented")
    }
}

class ImageLoader : LoaderWithProgress() {
    override fun load(){
        innerLoad()
    }

    override fun innerLoad() {
        TODO("Not yet implemented")
    }
}

fun test1(){

}

suspend fun main() = runBlocking{
    test1()
}