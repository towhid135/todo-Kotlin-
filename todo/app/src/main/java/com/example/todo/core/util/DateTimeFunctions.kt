import com.example.todo.core.util.FormattedDate
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

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
    return FormattedDate(
        dayName = dayNameFormatter.format(instant),
        dayNumber = dayNumberFormatter.format(instant).toInt()
    )
}