package entity

import SuaiRaspClient
import models.LessonDTO

class Lesson internal constructor(suaiRaspClient: SuaiRaspClient, val building: String, val rooms: String, val groups: List<Group>, val teachers: List<Teacher>){
        
}