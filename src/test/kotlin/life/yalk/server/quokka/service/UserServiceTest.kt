package life.yalk.server.quokka.service

import life.yalk.server.quokka.model.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {

    val userService = UserService();

    @Test
    fun createUserTest() {
        val user = User()
        val created = userService.createUser(user)
        Assertions.assertNotEquals(user.id, created.id)
    }

    @Test
    fun getUserOptionalTest() {
        val user = User()
        val created = userService.createUser(user)
        val foundOptional = userService.getUserOptional(created.id)
        assert(foundOptional.isPresent)
        Assertions.assertEquals(created, foundOptional.get())
    }

    @Test
    fun deleteUserTest() {
        val user = User()
        val created = userService.createUser(user)
        val foundOptional = userService.getUserOptional(created.id)
        assert(foundOptional.isPresent)
        userService.deleteUser(foundOptional.get().id)
        val deletedOptional = userService.getUserOptional(created.id)
        assert(deletedOptional.isEmpty)
    }
}
