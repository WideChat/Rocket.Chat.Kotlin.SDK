package chat.rocket.core.model

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class ContactHolder(
        val u: String,
        val h: String
)

@JsonSerializable
data class QueryContactResult(
        val strongHashes: List<ContactHolder>
)