package chat.rocket.core.internal.model

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class InviteSMSPayload(
    val phone: String,
    val language: String
)