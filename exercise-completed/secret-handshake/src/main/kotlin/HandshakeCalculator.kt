object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
            var n = number
            var signalList = emptyList<Signal>().toMutableList()
            while(n > 0) {
                if(n >= 16) {
                    signalList.reverse()
                    n -= 16
                }
                else if(n >= 8) {
                    n -= 8
                    signalList.add(0,Signal.JUMP)
                }
                else if(n >= 4) {
                    n -= 4
                    signalList.add(0,Signal.CLOSE_YOUR_EYES)
                } else if(n >= 2) {
                    n-= 2
                    signalList.add(0,Signal.DOUBLE_BLINK)
                } else {
                    n-= 1
                    signalList.add(0,Signal.WINK)
                }
            }
        return signalList

        }

    }




fun main() {
    println(HandshakeCalculator.calculateHandshake(31))
}
