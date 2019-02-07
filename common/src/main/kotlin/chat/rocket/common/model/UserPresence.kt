package chat.rocket.common.model

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class UserPresence(
    val presence: String?,
    val success: Boolean?
)