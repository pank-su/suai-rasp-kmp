package entity

import SuaiRaspClient
import models.Info
import models.LessonDTO

sealed class Week(val days: List<Day>) {
    
}

class Schedule internal constructor(private val suaiRaspClient: SuaiRaspClient, private val lessonsDTO: List<LessonDTO>, private val info: Info)  {
    
    suspend fun update(){
        TODO("обновлять инфо и если оно изменилось то загружать расписание")
    }
    
    fun today(){
        
    }
}