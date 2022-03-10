import kotlin.random.Random

class Robot {
    companion object {
        private var generatedNames: MutableList<String> = emptyList<String>().toMutableList()
    }

    private var status = false // name generated -> true, false otherwise
    private val charsPool: List<Char> = CharRange('A', 'Z').toList()
    var name: String =""
        get() {
            if(status ) return field;
            var tempName = "";
            do {
                tempName = (charsPool.get(Random.nextInt(0, charsPool.size)).toString() + charsPool.get(Random.nextInt(0, charsPool.size)).toString() + Random.nextInt(100, 999)).toString()
            }while (generatedNames.contains(tempName))
            generatedNames.add(tempName)
            status = true
            name = tempName
            return tempName
        }

    fun reset() {
        generatedNames.remove(name)
        status = false
        name = ""
    }
}

fun main() {
    var robot1 = Robot()
    var robot2 = Robot()
    println("Name of robot1 is ${robot1.name}")
    println("Name of robot2 is ${robot2.name}")
    robot1.reset()
    println("Name of robot1 is ${robot1.name}")

}