package life.yalk.server.quokka.service

import life.yalk.server.quokka.model.Message
import life.yalk.server.quokka.repository.InMemoryMessageRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MessageServiceTest {

    private final val messageRepository = InMemoryMessageRepository()
    private final val messageService = MessageService(messageRepository);

    val user1 = 1L
    val user2 = 2L

    @Test
    fun getMessagesTest() {
        assertSame(messageService.getReceivedMessages(user1), emptyList<Message>())
        assertSame(messageService.getReceivedMessages(user2), emptyList<Message>())
    }

    @Test
    fun sendTest() {
        assertSame(messageService.getReceivedMessages(user1), emptyList<Message>())
        assertSame(messageService.getReceivedMessages(user2), emptyList<Message>())
        messageService.sendMessage(user2, Message(user1, user2))
        assertSame(messageService.getReceivedMessages(user1), emptyList<Message>())
        assertSame(messageService.getReceivedMessages(user2).size, 1)
    }
}
