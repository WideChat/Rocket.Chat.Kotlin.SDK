package chat.rocket.core.internal.rest

import chat.rocket.common.model.RoomType
import chat.rocket.core.RocketChatClient
import chat.rocket.core.internal.RestResult
import chat.rocket.core.internal.model.CreateNewChannelPayload
import chat.rocket.core.model.Room
import com.squareup.moshi.Types
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.withContext
import okhttp3.Request
import okhttp3.RequestBody

suspend fun RocketChatClient.createChannel(roomType: RoomType, name: String, usersList: List<String>?, readOnly: Boolean? = false): Room = withContext(CommonPool) {
    val payload = CreateNewChannelPayload(name, usersList, readOnly)
    val adapter = moshi.adapter(CreateNewChannelPayload::class.java)
    val payloadBody = adapter.toJson(payload)
    val body = RequestBody.create(MEDIA_TYPE_JSON, payloadBody)

    val url = requestUrl(restUrl, getRestApiMethodNameByRoomType(roomType, "create")).build()

    val request = Request.Builder().url(url).post(body).build()
    val type = Types.newParameterizedType(RestResult::class.java, Room::class.java)

    return@withContext handleRestCall<RestResult<Room>>(request, type).result()
}

