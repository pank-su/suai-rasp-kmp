class ScheduleApi(private val client: Client) {
    fun byGroup(groupId: Int) {
        TODO()
    }

    fun byProfessor(professorId: Int) {
        TODO()
    }

    fun byGroupAndProfessor(groupId: Int, professorId: Int) {
        TODO()
    }

    operator fun get(groupId: Int) {}

    operator fun get(groupId: Int, professorId: Int) {}

    operator fun invoke(groupId: Int, professorId: Int? = null) {}
}