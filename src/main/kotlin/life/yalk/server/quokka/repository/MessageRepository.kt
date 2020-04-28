package life.yalk.server.quokka.repository

import life.yalk.server.quokka.model.Message

interface MessageRepository {
    fun getMessages(userId: Long): List<Message>
    fun addMessage(userId: Long, message: Message)
}
