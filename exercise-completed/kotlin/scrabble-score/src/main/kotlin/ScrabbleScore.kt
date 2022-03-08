object ScrabbleScore {

    fun scoreLetter(c: Char): Int {
        var score: Int = 0
        when(c.uppercaseChar()) {
            'A', 'E', 'I', 'O', 'U', 'L', 'N','R', 'S', 'T' -> score = 1
            'D', 'G' -> score = 2
            'B', 'C', 'M', 'P' -> score = 3
            'F','H', 'V', 'W', 'Y' -> score = 4
            'K' -> score = 5
            'J', 'X' -> score = 8
            'Q', 'Z' -> score = 10
        }

        return score
    }

    fun scoreWord(word: String): Int {
        return word.map { scoreLetter(it) }.fold(0, {total, score -> total + score})
    }
}
