object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        var flattened = source.flatMap{if(it is List<Any?>) flatten(it) else listOf(it)}.filterNotNull()

        return flattened
    }
}


fun main() {
    val nestedList = listOf(1, listOf(2, 3, 4, 5, 6, 7), 8)
    //val nestedList = listOf(listOf(1))
    //println(nestedList.map { if(it is List<*>) {println(it); it.map { it }} else it})

    var result = Flattener.flatten(nestedList)
    println(result)
}



/*
* [] -> []
* [1] -> [1]
* [[1]] -> [1] ->
*
* */