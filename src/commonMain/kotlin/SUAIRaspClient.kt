import io.ktor.client.*
import io.ktor.client.engine.*

class SuaiRaspClient internal constructor(engine: HttpClientEngine?, val basicUrl: String) {

    val schedule = lazy {
        ScheduleApi(this)
    }
    
    suspend fun groups(){
        TODO()
    }
    
    suspend fun directions(){
        TODO()
    }
    
    
    suspend fun semInfo(){
        TODO()
    }
    
    suspend fun proffesors(){
        TODO()
    }
    
    suspend fun builds(){
        TODO()
    }
    
    suspend fun version(){
        TODO()
    }
}

class SuaiRaspClientBuilder{
    var engine: HttpClientEngine? = null
    var basicUrl = "https://api.guap.ru/rasp/custom"
}

/**
 * Создать объект клиента расписания с настройками выбранного движка для ktor и ссылки для расписания
 * @see SuaiRaspClient
 * @see SuaiRaspClientBuilder
 */
fun createSuaiRaspClient(init: SuaiRaspClientBuilder.() -> Unit ): SuaiRaspClient {
    val builder = SuaiRaspClientBuilder().also(init)
    return SuaiRaspClient(builder.engine, builder.basicUrl)
}