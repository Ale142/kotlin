internal fun twofer(name: String): String {
   return if (name.isBlank()) "One for you, one for me." else "One for $name, one for me."
}
