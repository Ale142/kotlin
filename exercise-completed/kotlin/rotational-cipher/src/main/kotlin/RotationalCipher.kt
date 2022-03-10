class RotationalCipher(key: Int) {
    private var key = 0
    private var alphabet = CharRange('a', 'z').toList()
    init {
        this.key = key % 26
    }

    fun encode(text: String): String {
        val cipheredText = text.toCharArray().map {
            val index = alphabet.indexOf(it.lowercaseChar())
            var changedChar: Char = it
            if(index != -1) {
                changedChar = alphabet.get( (index + key) % alphabet.size)
            }
            if(it.isUpperCase()) changedChar.uppercaseChar() else changedChar
        }

        return cipheredText.joinToString("")
    }
}
