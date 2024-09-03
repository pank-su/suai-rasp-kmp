import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import models.TeacherDTO
import kotlin.test.Test
import kotlin.test.assertEquals

class GetTeachers {

    private val mockEngine = MockEngine {
        respond(
            """[{"Name":"Агапудов Д.В. — старший преподаватель","ItemId":433},{"Name":"Аграновский А.В. — доцент, канд. техн. наук, доцент","ItemId":27}]""",
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    @Test
    fun teachersSerializationIsValid() = runTest {
        val client = createSuaiRaspClient {
            this.engine = mockEngine
        }

        assertEquals(
            listOf(
                TeacherDTO(433, "Агапудов Д.В. — старший преподаватель"),
                TeacherDTO(27, "Аграновский А.В. — доцент, канд. техн. наук, доцент")
            ), client.teachers().map { TeacherDTO(it.id, it.name) }
        )
    }
}