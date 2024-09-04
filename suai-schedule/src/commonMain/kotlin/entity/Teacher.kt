package entity

import SuaiRaspClient
import models.TeacherDTO

class Teacher(val id: Int, val name: String, private val client: SuaiRaspClient)  {

    internal constructor(client: SuaiRaspClient, teacher: TeacherDTO): this(teacher.id, teacher.name, client)

    // FEATURE: добавить поиск среди личного кабинета?
    
    /**
     * Получение расписание по преподавателю
     */
    suspend fun schedule() = client.schedule.byTeacher(id)

}