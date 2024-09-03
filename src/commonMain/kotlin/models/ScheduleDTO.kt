package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO: созздать структуру данных для получения текущего расписания, следующего и т.п.
@Serializable
internal data class ScheduleDayDTO(
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
)