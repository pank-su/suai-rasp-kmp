package entity

import SuaiRaspClient
import kotlinx.datetime.LocalTime
import models.LessonDTO


class Lesson internal constructor(
    suaiRaspClient: SuaiRaspClient,
    val building: String,
    val rooms: String,
    val groups: List<Group>,
    val teachers: List<Teacher>,
    val startAt: LocalTime,
    val endAt: LocalTime
) {
}