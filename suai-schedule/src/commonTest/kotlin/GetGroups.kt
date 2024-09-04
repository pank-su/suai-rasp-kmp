import entity.Group
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetGroups {
    private val mockEngine = MockEngine{
        respond(
            """[{"Name":"1032","ItemId":103},{"Name":"1035","ItemId":9}]""",
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }
    
    @Test
    fun groupsDeserializingIsValid() = runTest {
        val client = createSuaiRaspClient {
            engine = mockEngine
        }
        
        assertEquals(listOf(103, 9), client.groups().map { it.id })
        assertEquals(listOf("1032", "1035"), client.groups().map { it.name })
    }
}