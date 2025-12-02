import com.example.todo.core.util.FormattedDate
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.LocalTime

fun formatTimestampToHourMinute(timestamp: Long): String {
    val instant = Instant.ofEpochMilli(timestamp)
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
        .withZone(ZoneId.systemDefault())
    return formatter.format(instant)
}

fun timeStampToDate(timestamp: Long): FormattedDate {
    val instant = Instant.ofEpochMilli(timestamp)
    val dayNameFormatter = DateTimeFormatter.ofPattern("EEE")
        .withZone(ZoneId.systemDefault())
    val dayNumberFormatter = DateTimeFormatter.ofPattern("d")
        .withZone(ZoneId.systemDefault())
        .withZone(ZoneId.systemDefault())
    val monthNameFormatter = DateTimeFormatter.ofPattern("MMMM")
        .withZone(ZoneId.systemDefault())
    val monthNumberFormatter = DateTimeFormatter.ofPattern("MM")
        .withZone(ZoneId.systemDefault())
    val yearFormatter = DateTimeFormatter.ofPattern("yy")
        .withZone(ZoneId.systemDefault())
    return FormattedDate(
        dayName = dayNameFormatter.format(instant),
        dayNumber = dayNumberFormatter.format(instant).toInt(),
        monthName = monthNameFormatter.format(instant),
        monthNumber = monthNumberFormatter.format(instant).toInt(),
        year = yearFormatter.format(instant).toInt()
    )
}


fun getStartOfDayMillis(date: LocalDate): Long {
    return date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
}

fun getEndOfDayMillis(date: LocalDate): Long {
    return date.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}