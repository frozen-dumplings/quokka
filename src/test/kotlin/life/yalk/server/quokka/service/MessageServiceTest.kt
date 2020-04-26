package life.yalk.server.quokka.service

import life.yalk.server.quokka.model.Message
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MessageServiceTest {

    val messageService = MessageService();

    val user1 = 1L
    val user2 = 2L

    @Test
    fun getMessagesTest() {
        Assertions.assertSame(messageService.getMessages(user1), emptyList<Message>())
        Assertions.assertSame(messageService.getMessages(user2), emptyList<Message>())
    }

    @Test
    fun sendTest() {
        Assertions.assertSame(messageService.getMessages(user1), emptyList<Message>())
        Assertions.assertSame(messageService.getMessages(user2), emptyList<Message>())
        messageService.sendMessage(Message(user1, user2))
        Assertions.assertSame(messageService.getMessages(user1), emptyList<Message>())
        Assertions.assertSame(messageService.getMessages(user2).size, 1)
    }
}
