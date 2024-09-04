package models

import SuaiRaspClient
import entity.Group
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GroupDTO(@SerialName("ItemId") val id: Int, @SerialName("Name") val name: String){
    fun toGroup(client: SuaiRaspClient) = Group(id, name, client)
}