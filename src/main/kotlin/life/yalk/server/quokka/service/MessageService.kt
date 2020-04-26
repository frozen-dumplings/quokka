package life.yalk.server.quokka.service

import life.yalk.server.quokka.model.Message
import org.springframework.stereotype.Service

@Service
class MessageService {

    val messageStorage: MutableMap<Long, List<Message>> = mutableMapOf()

    fun getMessages(user: Long): List<Message> {
        return messageStorage.getOrDefault(user, emptyList())
    }

    fun sendMessage(msg: Message) {
        val messages = messageStorage.getOrDefault(msg.receiver, emptyList())
        messageStorage[msg.receiver] = messages + listOf(msg)
    }
}
