import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.math.pow

class Gigasecond(){
    private val gigasecond: Long = 10.0.pow(9).toLong();
    var date: LocalDateTime = LocalDateTime.now();

    // TODO: Implement proper constructor
    constructor(data: LocalDateTime) : this() {
        date = data.plusSeconds(gigasecond)
    }

    constructor(data: LocalDate): this() {
        date = LocalDateTime.of(data, LocalTime.of(0, 0)).plusSeconds(gigasecond)
    }
}

fun main() {

}