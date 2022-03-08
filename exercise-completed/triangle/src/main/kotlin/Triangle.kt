class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
    var sides: List<Double> = emptyList()
    // TODO: Implement proper constructor
    init {
       sides = listOf(a, b, c).map { it.toDouble() }
        require(sides[0] > 0 && sides[1] > 0 && sides[2] > 0)
        for(side in sides) {
            var otherSides = sides.minus(side)
            if(side > otherSides.sum()) throw IllegalArgumentException("Not a triangle")
        }
    }

    val isEquilateral: Boolean = sides.all { it.equals(sides[0]) }
    val isIsosceles: Boolean = sides.map { it.equals(sides[0]) }.count{it === true} === 2
    val isScalene: Boolean = sides.map { it.equals(sides[0]) }.count{it === true} === 1
}

fun main() {
    println(Triangle<Int>(2,3,10).isIsosceles)
}