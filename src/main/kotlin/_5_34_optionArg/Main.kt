package _5_34_optionArg

import kotlinx.coroutines.runBlocking

data class Student(
    val name : String,
    val surname : String,
    val age : Int
)

class QuotationView{
    fun showQuote(quote : Int){}
}
class QuotationRepository{
    val quotesNumber = 0
    fun getQuote(next : Int) = 3
}
class QuotationPresenter(
    private val view: QuotationView,
    private val repo: QuotationRepository
){
    private var nextQuoteId = -1

    fun onStart() {
        onNext()
    }

    fun onNext() {
        nextQuoteId = (nextQuoteId + 1) % repo.quotesNumber
        val quote = repo.getQuote(nextQuoteId)
        view.showQuote(quote)
    }
}

//class Pizza {
//    val size: String
//    val cheese: Int
//    val olives: Int
//    val bacon: Int
//
//    constructor(size: String, cheese: Int, olives: Int, bacon: Int){
//        this.size = size
//        this.cheese = cheese
//        this.olives = olives
//        this.bacon = bacon
//    }
//    constructor(size: String, cheese: Int, olives: Int):this(size, cheese, olives, 0)
//    constructor(size: String, cheese: Int): this(size, cheese, 0)
//    constructor(size: String): this(size, 0)
//}

class Pizza(
    val size: String,
    val cheese: Int = 0,
    val olives: Int = 0,
    val bacon: Int = 0
)

class Pizza2 private constructor(
    val size: String,
    val cheese: Int,
    val olives: Int,
    val bacon: Int
){
    class Builder(private val size: String){
        private var cheese: Int = 0
        private var olives: Int = 0
        private var bacon: Int = 0

        fun setCheese(value: Int): Builder = apply {
            cheese = value
        }

        fun setOlives(value: Int): Builder = apply {
            olives = value
        }

        fun setBacon(value: Int):Builder = apply {
            bacon = value
        }

        fun build() = Pizza2(size, cheese, olives, bacon)
    }


}

fun test1(){
    val myFavorite3 = Pizza2.Builder("L").setOlives(3).build()
    val villagePizza2 = Pizza2.Builder("L").setCheese(1).setOlives(2).setBacon(3).build()

    val myFavorite = Pizza("L", olives = 3)
    val myFavorite2 = Pizza("L", olives = 3, cheese = 1)
    val villagePizza = Pizza(size = "L", cheese = 1, olives = 2, bacon = 3)

}

suspend fun main() = runBlocking{
    test1()
}