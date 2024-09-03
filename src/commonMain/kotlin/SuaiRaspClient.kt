import entity.Teacher
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import models.Info
import models.TeacherDTO

class SuaiRaspClient internal constructor(engine: HttpClientEngine?, internal val basicUrl: String) {

    internal val client = (if (engine == null) HttpClient() {
        setUp()
    } else HttpClient(engine) {
        setUp()
    })

    private fun HttpClientConfig<*>.setUp() {
        install(ContentNegotiation) {
            json()
        }
    }

    val schedule by lazy {
        ScheduleApi(this)
    }

    suspend fun groups() {
        TODO()
    }

    suspend fun directions() {
        TODO()
    }

    // TODO: Не работает на сервере можно перенести на другое апи
    suspend fun rooms(buildingId: Int) {
        TODO()
    }

    suspend fun info(): Info =
        client.get(basicUrl) {
            url {
                this.appendPathSegments("get-sem-info")
            }
        }.body<Info>()


    suspend fun version() {
        TODO()
    }

    suspend fun teachers(): List<Teacher> = client.get(basicUrl) {
        url {
            this.appendPathSegments("get-sem-preps")
        }
    }.body<List<TeacherDTO>>().map { it.toTeacher(this) }

    suspend fun builds() {
        TODO()
    }

}

class SuaiRaspClientBuilder {
    var engine: HttpClientEngine? = null
    var basicUrl = "https://api.guap.ru/rasp/custom"
}

/**
 * Создать объект клиента расписания с настройками выбранного движка для ktor и ссылки для расписания
 * @see SuaiRaspClient
 * @see SuaiRaspClientBuilder
 */
fun createSuaiRaspClient(init: SuaiRaspClientBuilder.() -> Unit): SuaiRaspClient {
    val builder = SuaiRaspClientBuilder().also(init)
    return SuaiRaspClient(builder.engine, builder.basicUrl)
}