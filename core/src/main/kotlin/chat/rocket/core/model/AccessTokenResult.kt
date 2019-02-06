package chat.rocket.core.model

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class AccessTokenResult(
        val accessToken: String
)