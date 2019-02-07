package chat.rocket.core.internal.rest

import chat.rocket.core.RocketChatClient
import chat.rocket.core.internal.model.AccessTokenPayload
import chat.rocket.core.model.AccessTokenResult
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.withContext
import okhttp3.RequestBody

suspend fun RocketChatClient.getAccessToken(serviceName: String) : String = withContext(CommonPool) {
    val payload = AccessTokenPayload(serviceName)
    val adapter = moshi.adapter(AccessTokenPayload::class.java)
    val payloadBody = adapter.toJson(payload)
    val body = RequestBody.create(MEDIA_TYPE_JSON, payloadBody)
    val url = requestUrl(restUrl, "users.getServiceAccessToken").build()
    val request = requestBuilderForAuthenticatedMethods(url).post(body).build()
    val result = handleRestCall<AccessTokenResult>(request, AccessTokenResult::class.java)
    result.accessToken
}
