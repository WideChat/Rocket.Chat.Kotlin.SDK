package chat.rocket.core.internal.rest

import chat.rocket.core.RocketChatClient
import chat.rocket.core.internal.model.QueryContactsPayload
import chat.rocket.core.model.ContactHolder
import chat.rocket.core.model.QueryContactResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.RequestBody

suspend fun RocketChatClient.queryContacts(weakHashes: List<String>): List<ContactHolder> = withContext(Dispatchers.io) {
    val payload = QueryContactsPayload(weakHashes)
    val adapter = moshi.adapter(QueryContactsPayload::class.java)
    val payloadBody = adapter.toJson(payload)
    val body = RequestBody.create(MEDIA_TYPE_JSON, payloadBody)
    val url = requestUrl(restUrl, "query.contacts").build()
    val request = requestBuilderForAuthenticatedMethods(url).post(body).build()
    val result = handleRestCall<QueryContactResult>(request, QueryContactResult::class.java)
    result.strongHashes
}