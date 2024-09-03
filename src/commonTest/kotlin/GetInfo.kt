import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDateTime
import models.Info
import kotlin.test.Test
import kotlin.test.assertEquals

class GetInfo {

    val mockEngine = MockEngine() {
        respond(
            """{"Years":"2024/25","IsAutumn":true,"Update":"2024-08-30T17:36:01","CurrentWeek":1,"IsWeekOdd":true,"IsWeekUp":true,"IsWeekRed":true}""",
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    /**
     * Проверка корректности модели для дессерилизации информации о расписании
     */
    @Test
    fun infoDesiralizationIsValid() = runTest {
        val client = createSuaiRaspClient {
            engine = mockEngine
        }

        val info = client.info()
        assertEquals(
            Info(
                "2024/25", true, LocalDateTime.parse("2024-08-30T17:36:01"), 1,
                true,
                true,
                true
            ), info
        )

    }
}