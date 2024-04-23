package _6_39_ClassStructure

import kotlinx.coroutines.runBlocking
import kotlin.properties.Delegates


class OldValueMatcher<T> private constructor(
    private val value: T? = null,
    private val matcher: Matcher
){
    fun match(value: T?) = when(matcher) {
        Matcher.EQUAL -> value == this.value
        Matcher.NOT_EQUAL -> value != this.value
        Matcher.LIST_EMPTY -> value is List<*> && value.isEmpty()
        Matcher.LIST_NOT_EMPTY -> value is List<*> && value.isNotEmpty()
    }

    enum class Matcher {
        EQUAL,
        NOT_EQUAL,
        LIST_EMPTY,
        LIST_NOT_EMPTY
    }

    companion object {
        fun <T> equal(value: T) =
            OldValueMatcher<T>(value = value, matcher = Matcher.EQUAL)

        fun <T> notEqual(value: T) =
            OldValueMatcher<T>(value = value, matcher = Matcher.NOT_EQUAL)

        fun <T> emptyList(value: T) =
            OldValueMatcher<T>(value = value, matcher = Matcher.LIST_EMPTY)

        fun <T> notEmptyList(value: T) =
            OldValueMatcher<T>(value = value, matcher = Matcher.LIST_NOT_EMPTY)
    }
}

sealed class ValueMatcher<T> {
    abstract fun match(value : T): Boolean

    class Equal<T>(val value: T) : ValueMatcher<T>() {
        override fun match(value: T) =
            value == this.value
    }

    class NotEqual<T>(val value: T) : ValueMatcher<T>() {
        override fun match(value: T) =
            value != this.value
    }

    class EmptyList<T> : ValueMatcher<T>() {
        override fun match(value: T) =
            value is List<*> && value.isEmpty()
    }

    class NotEmptyList<T> : ValueMatcher<T>() {
        override fun match(value: T) =
            value is List<*> && value.isNotEmpty()
    }
}

fun <T> ValueMatcher<T>.reversed(): ValueMatcher<T> =
    when(this){
        is ValueMatcher.EmptyList -> ValueMatcher.NotEmptyList<T>()
        is ValueMatcher.NotEmptyList -> ValueMatcher.EmptyList<T>()
        is ValueMatcher.Equal -> ValueMatcher.NotEqual<T>(value)
        is ValueMatcher.NotEqual -> ValueMatcher.Equal<T>(value)
    }

class Exercise

sealed class WorkoutState
class PrepareState(val exercise: Exercise) : WorkoutState()
class ExerciseState(val exercise: Exercise) : WorkoutState()
object DoneState : WorkoutState()

fun List<Exercise>.toStates(): List<WorkoutState> =
    flatMap { exercise ->
        listOf(PrepareState(exercise), ExerciseState(exercise))
    } + DoneState

class WorkoutPresenter(){
    private val states = listOf<WorkoutState>()
    private var state: WorkoutState by
            Delegates.observable(states.first()){_, _, _ ->
                updateView()
            }

    fun updateView(){}
}

fun test1(){


}

suspend fun main() = runBlocking{
    test1()
}