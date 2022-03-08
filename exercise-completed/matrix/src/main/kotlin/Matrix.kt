class Matrix(private val matrixAsString: String) {


    fun column(colNr: Int): List<Int> {
        return matrixAsString.split("\n").map({it.trim().replace(Regex("\\s+"), " ").split(" ")}).map { it[colNr-1] }.map { it.toInt() }
    }

    fun row(rowNr: Int): List<Int> {

        return matrixAsString.split("\n")[rowNr-1].trim().replace(Regex("\\s+"), " ").split(" ").map { it.toInt() }
    }
}
