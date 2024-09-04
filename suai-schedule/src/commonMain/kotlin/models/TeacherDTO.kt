package models

import SuaiRaspClient
import entity.Teacher
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TeacherDTO(@SerialName("ItemId") val id: Int, @SerialName("Name") val name: String){
    fun toTeacher(client: SuaiRaspClient) = Teacher(client, this)
}