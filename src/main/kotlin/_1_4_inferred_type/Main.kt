package _1_4_inferred_type

import kotlinx.coroutines.runBlocking

open class Car
class Fiat126P : Car()
class CocoCar : Car()
val DEFAULT_CAR = Fiat126P()
val COCO_CAR = CocoCar()
interface CarFactory {
    fun produce() : Car = DEFAULT_CAR
}



fun test1(){

    open class Animal
    class Zebra: Animal()

    var animal : Animal = Zebra()
    animal = Animal()

    val factory = object : CarFactory{
        override fun produce() = COCO_CAR
    }

    val car: Car = factory.produce()


}


suspend fun main() = runBlocking{
    test1()
}