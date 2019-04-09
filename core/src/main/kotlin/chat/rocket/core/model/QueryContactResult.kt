package chat.rocket.core.model

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class ContactHolder(
        @Json(name = "_id") val id: String,
        val u: String,
        val h: String
)

@JsonSerializable
data class QueryContactResult(
        val strongHashes: List<ContactHolder>
)