package entity

import SuaiRaspClient
import models.TeacherDTO

class Teacher(val client: SuaiRaspClient, teacher: TeacherDTO) {
    val id: Int = teacher.id
    val name: String = teacher.name
    
    suspend fun rasp() = client.schedule.byTeacher(id)
}