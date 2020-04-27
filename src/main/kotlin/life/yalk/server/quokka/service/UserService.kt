package life.yalk.server.quokka.service

import life.yalk.server.quokka.model.User
import org.springframework.stereotype.Service

@Service
class UserService {

    private val userStorage: MutableMap<Long, User> = mutableMapOf()

    fun createUser(user: User): User {
        val newId = userStorage.size.toLong()
        val created = User(newId, user)
        userStorage[newId] = created
        return created
    }

    fun getUser(id: Long?): User? {
        return userStorage[id]
    }

    fun deleteUser(id: Long?): Boolean {
        val deleted = userStorage.remove(id)
        return deleted != null
    }
}
