object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        var counter = emptyMap<String, Int>().toMutableMap()
        val string = phrase.split(Regex("[^a-zA-Z0-9']+")).map { it.trim('\'').lowercase().trim() }.filter{!it.isEmpty()}

        string.forEach { if (counter.containsKey(it)) counter.set(it, counter.getValue(it) + 1) else counter.set(it, 1) }
        return counter
    }
}