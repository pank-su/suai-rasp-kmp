package entity

import SuaiRaspClient

class Group(val id: Int, val name: String, private val suaiRaspClient: SuaiRaspClient) {
    
    /**
     * Получение расписание по группе
     */
    suspend fun schedule(){
        
    }
}