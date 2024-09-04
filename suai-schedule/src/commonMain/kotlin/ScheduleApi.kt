import entity.Teacher
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import models.LessonDTO

class ScheduleApi(private val suaiClient: SuaiRaspClient) {


    suspend fun byGroup(groupId: Int) {
        TODO()
    }

    suspend fun byTeacher(teacherId: Int) {
        suaiClient.client.get(suaiClient.basicUrl) {
            url{
                appendPathSegments("get-sem-rasp/prep${teacherId}")
            }
        }.body<LessonDTO>()
    }

    suspend fun byTeacher(teacher: Teacher) = byTeacher(teacher.id)

    fun byGroupAndProfessor(groupId: Int, professorId: Int) {
        TODO()
    }

    suspend operator fun invoke(groupId: Int, professorId: Int? = null) =
        if (professorId == null) {
            byGroup(groupId)
        } else {
            byGroupAndProfessor(groupId, professorId)
        }

}