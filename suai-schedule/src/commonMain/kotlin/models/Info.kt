package models

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Представление информации о текущей расписании
 * @param years текущий год обучения
 * @param isAutumn сейчас осень? (что? зачем?)
 * @param update время последнего обновления расписания
 * @param weekNumber номер текущей недели
 * @param isOdd неделя нечётная?
 * @param isUp неделя верхняя?
 * @param isRed неделя красная?
 * [isOdd] & [isUp] & [isRed] фактически  обозначают одно и тоже
 */
@Serializable
data class Info(
    @SerialName("Years") val years: String,
    @SerialName("IsAutumn") val isAutumn: Boolean,
    @SerialName("Update") val update: LocalDateTime,
    @SerialName("CurrentWeek") val weekNumber: Int,
    @SerialName("IsWeekOdd") val isOdd: Boolean,
    @SerialName("IsWeekUp") val isUp: Boolean,
    @SerialName("IsWeekRed") val isRed: Boolean
)