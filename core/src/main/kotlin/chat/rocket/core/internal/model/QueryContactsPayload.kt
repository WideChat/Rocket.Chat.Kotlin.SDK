package chat.rocket.core.internal.model

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class QueryContactsPayload(val weakHashes: List<String>)