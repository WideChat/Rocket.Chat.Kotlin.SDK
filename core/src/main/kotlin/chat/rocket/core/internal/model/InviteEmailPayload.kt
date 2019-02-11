package chat.rocket.core.internal.model

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class InviteEmailPayload(
    val email: String,
    val language: String
)