import kotlin.properties.Delegates.observable

class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.

    interface Subscription {
        fun cancel()
    }

    abstract class Cell<T>{
        abstract val value: T
        var observers = emptyList<Cell<T>>().toMutableList()
    }

    inner class InputCell(inputVal: T): Cell<T>() {



       override var value: T by observable(inputVal) { kprop, oldVal, newVal ->
            println("old: $oldVal | new: $newVal")
           observers.forEach{(it as Reactor<*>.ComputeCell).compute()}
       }
    }

    inner class ComputeCell(vararg var inputCells: Cell<T>, var computeFun: (parameters: List<T>) -> T): Cell<T>() {
        init {
            inputCells.forEach { it.observers.add(this) }
        }
        override var value: T = inputCells[0].value
        var callbacks = emptyList<CallbackObject>().toMutableList()
        fun compute() {

            value = computeFun(inputCells.map { it.value })
            callbacks.forEach { it.function }
        }

        fun addCallback(callback: (par: T) -> Boolean): CallbackObject {
            val cbObj = CallbackObject(callback)
            callbacks.add(cbObj)
            return cbObj
        }

        inner class CallbackObject(var function: (par: T) -> Boolean): Subscription {

            override fun cancel() {
                callbacks.remove(this)
            }

        }
    }

}
