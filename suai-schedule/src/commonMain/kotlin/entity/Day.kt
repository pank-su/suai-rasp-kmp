package entity

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.*
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

/**
 * сделать как-то адекватно список весь пар, а также расписание звонков для ФСПО
 *
 * есть идея просто список из 6 элементов или сколько максимально пар, а пропущенные пары это null
 */
class Day(val dayOfWeek: DayOfWeek, lessons: Map<Int, Lesson>, schedule: Schedule) {
    val lessons = buildList {
        repeat(6) {
            add(lessons[it])
        }
    }

    fun lessonByTime(time: LocalTime) =
        lessons.first { if (it != null) it.startAt < time && it.endAt > time else false }



   


    
}