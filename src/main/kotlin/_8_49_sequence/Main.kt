package _8_49_sequence

import kotlinx.coroutines.runBlocking

fun test1(){
    val seq = sequenceOf(1,2,3)
    val filtered = seq.filter { print("f$it "); it % 2 == 1}
    println(filtered)

    val asList = filtered.toList()
    println(asList)

    val list = listOf(1,2,3)
    val listFiltered = list
        .filter { print("f$it "); it % 2 == 1 }
    println(listFiltered)

    sequenceOf(1,2,3)
        .filter { print("F$it, "); it % 2 == 1 }
        .map {  print("M$it, "); it * 2 }
        .forEach { print("E$it, ") }
    println()

    listOf(1,2,3)
        .filter { print("F$it, "); it % 2 == 1 }
        .map {  print("M$it, "); it * 2 }
        .forEach { print("E$it, ") }

    println()
    for(e in listOf(1,2,3)) {
        print("F$e, ")
        if( e % 2 == 1){
            print("M$e, ")
            val mapped = e * 2
            print("E$mapped, ")
        }
    }
}

fun test2(){
    (1..10).asSequence()
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .find { it > 5 }

    println()
    (1..10)
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .find { it > 5 }

    println()
    generateSequence(1) { it + 1 }
        .map { it * 2 }
        .take(10)
        .forEach { print("$it, ") }

    println()
    val fibonacci = sequence {
        yield(1)
        var current = 1
        var prev = 1
        while(true){
            yield(current)
            val temp = prev
            prev = current
            current += temp
        }
    }
    print(fibonacci.take(10).toList())
}

fun test4(){
    val numbers = (1..10)
    numbers
        .filter { it % 10 == 0 }
        .map { it * 2 }
        .sum()

    numbers
        .asSequence()
        .filter { it % 10 == 0 }
        .map { it * 2 }
        .sum()
}

class Product(val bought : Boolean, val price: Double)
val productList = listOf<Product>()
fun singleStepListProcessing(): List<Product>{
    return productList.filter { it.bought }
}

fun singleStepSequenceProcessing(): List<Product>{
    return productList.asSequence()
        .filter { it.bought }
        .toList()
}

fun twoStepListProcessing(): List<Double>{
    return productList
        .filter { it.bought }
        .map { it.price }
}

fun twoStepSequenceProcessing(): List<Double>{
    return productList.asSequence()
        .filter { it.bought }
        .map { it.price }
        .toList()
}

fun threeStepListProcessing(): Double{
    return productList
        .filter { it.bought }
        .map { it.price }
        .average()
}

fun threeStepSequenceProcessing(): Double{
    return productList.asSequence()
        .filter { it.bought }
        .map { it.price }
        .average()
}

fun test5(){
    val list1 = generateSequence(0) { it + 1 }.take(10).sorted().toList()
    println(list1)
    val list2 = generateSequence(0) { it + 1 }.sorted().take(10).toList()
    println(list2)
}

fun productsSortAndProcessingList(): Double{
    return productList
        .sortedBy { it.price }
        .filter { it.bought }
        .map { it.price }
        .average()
}

fun productsSortAndProcessingSequence(): Double{
    return productList.asSequence()
        .sortedBy { it.price }
        .filter { it.bought }
        .map { it.price }
        .average()
}
fun test6(){
    productList.asSequence()
        .filter { it.bought }
        .map { it.price }
        .average()

    productList.stream()
        .filter { it.bought }
        .mapToDouble { it.price }
        .average()
        .orElse(0.0)
}

suspend fun main() = runBlocking{
    test6()
}