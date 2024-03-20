package _1_8_null

import kotlinx.coroutines.runBlocking
import kotlin.properties.Delegates

data class Printer(val name : String)

fun getPrinter() : Printer? = null
fun test1(){
    val printer : Printer? = getPrinter()
    val printerName1 = printer?.name ?: "Unnamed"
    val printerName2 = printer?.name ?: return
    val printerName3 = printer?.name ?:
        throw Error("Printer must be named")
}


data class News(val date : String)

fun getNews() : List<News>? = null
fun notifyUser(news: News) {
    println("news : ${news.date}")
}
fun test2(){
    println("What is your name?")
    val name = readLine()
    if(!name.isNullOrBlank()){
        println("Hello ${name.toUpperCase()}")
    }
    val news : List<News>? = getNews()
    if(!news.isNullOrEmpty()){
        news.forEach { notifyUser(it) }
    }
}

data class User(val name : String?)
class Context
val context = Context()
class NetworkService(val context: Context){
    fun getData(process : (String, User) -> Unit){/**/ }
}
fun getNetworkService(context: Context) = NetworkService(context)
class NoInternetConnection : Exception()
fun show(data : String, user: User){}
fun process(user: User){
    requireNotNull(user.name)
    val context = checkNotNull(context)
    val networkService = getNetworkService(context) ?: throw NoInternetConnection()

    networkService.getData { data, userData ->
        show(data!!, userData!!)
    }

}

fun largestOf(a: Int, b: Int, c: Int, d: Int): Int = listOf(a, b, c, d).max()!!

fun largestOf(vararg nums : Int): Int = nums.max()!!

class UserDao
class UserController(val userDao: UserDao){
    fun doSomething(){}
}

annotation class BeforeEach
annotation class Test
fun mockk() = UserDao()

class UserControllerTest {
    private lateinit var dao : UserDao
    private lateinit var controller: UserController

    @BeforeEach
    fun init() {
        dao = mockk()
        controller = UserController(dao)
    }

    @Test
    fun test(){
        controller.doSomething()
    }
}

class Bundle
class Extras{
    fun getInt(key: String) = 1
    fun getBoolean(key: String) = false
}
class Intent{
    val extras : Extras = Extras()
}

val DOCTOR_ID_ARG = "DOCTOR_ID_ARG"
val FROM_NOTIFICATION_ARG = "FROM_NOTIFICATION_ARG"
open class Activity{
    open val intent : Intent = Intent()
    open fun onCreate(savedInstanceState: Bundle?){}
}
class DoctorActivity: Activity() {
//    private var doctorId: Int by Delegates.notNull()
    private val doctorId: Int by lazy {
        arg(DOCTOR_ID_ARG)
    }

    private var fromNotification: Boolean by
            Delegates.notNull()
//    private lateinit var testId : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        doctorId = intent.extras.getInt(DOCTOR_ID_ARG)
        fromNotification = intent.extras.getBoolean(FROM_NOTIFICATION_ARG)
    }

    private fun arg(key : String) : Int = intent.extras.getInt(key)
}


suspend fun main() = runBlocking{
    test2()
}