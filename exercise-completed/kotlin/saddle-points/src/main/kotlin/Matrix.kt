data class MatrixCoordinate(val row: Int, val col: Int) {
    override fun toString(): String {
        return "<$row;$col>"
    }
}


class Matrix(private val elements: List<List<Int>>) {
    var saddlePoints: Set<MatrixCoordinate> = emptySet()

    init {
        println(elements)
        saddlePoints = findSaddlePoints()
    }
    inner class Cell(val row: Int, val col: Int, val value: Int) {
        override fun toString(): String {
            return "<i:$row, j:$col, v:$value>"
        }
    }

    private fun findSaddlePoints(): Set<MatrixCoordinate> {
        val maxRowsValue: MutableList<Cell> = emptyList<Cell>().toMutableList()
        var saddlePoints = emptySet<MatrixCoordinate>().toMutableSet()
        if(!elements.isEmpty() && !elements.contains(emptyList())) {
            elements.forEachIndexed { rowNr, el ->
                val maxElement = el.maxOrNull()!!
                el.forEachIndexed { colNr, i -> if (i == maxElement) maxRowsValue.add(Cell(rowNr + 1, colNr + 1, i)) }
            }


            maxRowsValue.forEach { if (getColumnByIndex(it.col).fold(true) { total, el -> total && (el >= it.value) }) saddlePoints.add(MatrixCoordinate(it.row, it.col)) }
        }
            return saddlePoints

    }

    private fun getColumnByIndex(index: Int): List<Int> {
        var columns = emptyList<Int>().toMutableList()
        elements.forEachIndexed { _, el ->
            el.forEachIndexed { colNr, element -> if (colNr == index - 1) columns.add(element) }
        }

        return columns
    }
}

