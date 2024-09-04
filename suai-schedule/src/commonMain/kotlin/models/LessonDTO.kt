package models

import SuaiRaspClient
import entity.Group
import entity.Lesson
import entity.Teacher
import kotlinx.datetime.LocalTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private val CALL_SCHEDULE = mapOf(
    1 to Pair(LocalTime(9, 30), LocalTime(11, 0)),
    2 to Pair(LocalTime(11, 10), LocalTime(12, 40)),
    3 to Pair(LocalTime(13, 0), LocalTime(14, 30)),
    4 to Pair(LocalTime(15, 0), LocalTime(16, 30)),
    5 to Pair(LocalTime(16, 40), LocalTime(18, 10)),
    6 to Pair(LocalTime(18, 30), LocalTime(20, 0)),
)

private val CALL_SCHEDULE_FSPO: Map<Int, Pair<LocalTime, LocalTime>> = TODO()


// TODO: созздать структуру данных для получения текущего расписания, следующего и т.п.
@Serializable
internal data class LessonDTO(
    @SerialName("ItemId") val id: Int,
    @SerialName("Week") val week: Int,
    @SerialName("Day") val day: Int,
    // номер лекции
    @SerialName("Less") val lessonNumber: Int,
    // номер здания
    @SerialName("Build") val build: String,
    // номер аудитории
    @SerialName("Rooms") val rooms: String,
    // название дисциплины
    @SerialName("Disc") val discipline: String,
    // тип пары
    @SerialName("Type") val type: String,
    // id групп
    @SerialName("Groups") val groupsIds: String,
    // название групп в читаемом виде
    @SerialName("GroupsText") val groupsText: String,
    // id преподвателей
    @SerialName("preps") val prepsIds: String?,
    // преподаватели в читаемом виде
    @SerialName("PrepsText") val prepsText: String,
    @SerialName("Dept") val deps: String?
) {

    fun toLesson(client: SuaiRaspClient): Lesson = Lesson(
        client,
        build,
        rooms,
        getGroups(client),
        getTeachers(client),
        CALL_SCHEDULE[lessonNumber]!!.first,
        CALL_SCHEDULE[lessonNumber]!!.second
    )

    fun getTeachers(client: SuaiRaspClient): List<Teacher> {
        if (prepsIds == null) return emptyList()
        val ids = Regex(":(?<num>\\d+):").findAll(prepsIds).map {
            it.groupValues.first().toInt()
        }.toList()
        val names = prepsText.split("; ")
        return ids.zip(names) { id, name ->
            Teacher(id, name, client)
        }
    }

    fun getGroups(client: SuaiRaspClient): List<Group> {
        val ids = Regex(":(?<num>\\d+):").findAll(groupsIds).map {
            it.groupValues.first().toInt()
        }.toList()
        val names = groupsText.split("; ")
        return ids.zip(names) { id, name ->
            Group(id, name, client)
        }
    }
}