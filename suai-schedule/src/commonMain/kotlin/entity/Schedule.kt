package entity

import SuaiRaspClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.*
import models.Info
import models.LessonDTO
import kotlin.time.Duration.Companion.seconds

sealed class Week(private val days: List<Day>) : Iterable<Day> {

    private val dayOfWeekToDay =
        days.associateBy { it.dayOfWeek }


    class Odd(days: List<Day>) : Week(days)

    class Even(days: List<Day>) : Week(days)

    operator fun get(dayOfWeek: DayOfWeek) = dayOfWeekToDay[dayOfWeek]!!

    override fun iterator(): Iterator<Day> = days.iterator()

}

class Schedule internal constructor(
    private val suaiRaspClient: SuaiRaspClient,
    lessonsDTO: List<LessonDTO>,
    private val info: Info
) {

    val odd: Week.Odd

    val even: Week.Even

    init {
        val byWeek = lessonsDTO.groupBy { it.week }.mapValues {
            it.value.groupBy { DayOfWeek(it.day) }.map {
                Day(
                    it.key,
                    it.value.associateBy { it.lessonNumber }.mapValues { it.value.toLesson(suaiRaspClient) },
                    this
                )
            }
        }
        odd = Week.Odd(byWeek[1]!!)
        even = Week.Even(byWeek[2]!!)
    }

    val currentWeek
        get() = if (info.isOdd) odd else even


    suspend fun update() {
        TODO("обновлять инфо и если оно изменилось то загружать расписание")
    }

    val lessonNow = flow<Lesson?> {
        TODO("Пока в разработке")
        while (true) {
            val dateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            val currentDay = currentWeek[dateTime.dayOfWeek]
            val timeNow = dateTime.time
            val lesson = currentDay.lessonByTime(timeNow)
            emit(lesson)
            if (lesson == null && currentDay.lessons.last{it != null}!!.endAt < timeNow){
                delay((currentWeek[DayOfWeek(dateTime.dayOfWeek.isoDayNumber + 1)].lessons.first{it != null}!!.startAt.toSecondOfDay() - timeNow.toSecondOfDay()).seconds)
                continue
            }
            // ожидать след. пары
            delay((60 - timeNow.second).seconds)
        }
    }

    fun today(): Day {
        TODO()
    }


}