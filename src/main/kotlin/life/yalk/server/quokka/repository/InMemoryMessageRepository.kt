package life.yalk.server.quokka.repository

import life.yalk.server.quokka.model.Message
import org.springframework.stereotype.Repository

@Repository
class InMemoryMessageRepository : MessageRepository {

    val messageStorage: MutableMap<Long, List<Message>> = mutableMapOf()

    override fun getMessages(userId: Long): List<Message> {
        return messageStorage.getOrDefault(userId, emptyList())
    }

    override fun addMessage(userId: Long, message: Message) {
        val messages = getMessages(userId)
        messageStorage[userId] = messages + listOf(message)
    }
}
