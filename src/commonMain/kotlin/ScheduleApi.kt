import entity.Teacher
import io.ktor.client.request.*

class ScheduleApi(private val suaiClient: SuaiRaspClient) {


    suspend fun byGroup(groupId: Int) {
        TODO()
    }

    suspend fun byTeacher(teacherId: Int) {
        suaiClient.client.get(suaiClient.basicUrl){

        }
    }

    suspend fun byTeacher(teacher: Teacher) = byTeacher(teacher.id)

    fun byGroupAndProfessor(groupId: Int, professorId: Int) {
        TODO()
    }

    suspend operator fun invoke(groupId: Int, professorId: Int? = null) {
        if (professorId == null){

        }else{
            
        }
    }
}