package life.yalk.server.quokka.service

import life.yalk.server.quokka.model.User
import life.yalk.server.quokka.repository.InMemoryUserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {

    private final val userRepository = InMemoryUserRepository()
    private final val userService = UserService(userRepository);

    @Test
    fun createUserTest() {
        val user = User()
        val created = userService.createUser(user)
        assertNotEquals(user.id, created.id)
    }

    @Test
    fun getUserOptionalTest() {
        val user = User()
        val created = userService.createUser(user)
        val found = userService.getUser(created.id!!)
        assertEquals(created, found)
    }

    @Test
    fun deleteUserTest() {
        val user = User()
        val created = userService.createUser(user)
        val found = userService.getUser(created.id!!)
        userService.deleteUser(found!!.id!!)
        val deleted = userService.getUser(created.id!!)
        assertNull(deleted)
    }
}
