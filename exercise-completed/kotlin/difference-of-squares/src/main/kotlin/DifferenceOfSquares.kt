class Squares(val n: Int) {
    //TODO: implement proper constructor

    fun sumOfSquares(): Int {
        var squares = n.downTo(1).toList().map { Math.pow(it.toDouble(), 2.0) }
        return squares.sum().toInt()
    }

    fun squareOfSum(): Int {
        var sumNumbers = n.downTo(1).toList().sum()
        return Math.pow(sumNumbers.toDouble(), 2.0).toInt()
    }

    fun difference(): Int {
        return (squareOfSum() - sumOfSquares()).toInt()
    }
}

fun main() {
    println(Squares(10).difference())
}