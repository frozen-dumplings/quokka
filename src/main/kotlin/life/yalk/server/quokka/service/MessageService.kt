package life.yalk.server.quokka.service

import life.yalk.server.quokka.model.Message
import life.yalk.server.quokka.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageService(@Autowired val messageRepository: MessageRepository) {

    fun getReceivedMessages(userId: Long): List<Message> {
        return messageRepository.getMessages(userId)
    }

    fun sendMessage(receiverId: Long, message: Message) {
        messageRepository.addMessage(receiverId, message)
    }
}
