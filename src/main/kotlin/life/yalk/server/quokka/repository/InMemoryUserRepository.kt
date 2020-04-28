package life.yalk.server.quokka.repository

import life.yalk.server.quokka.model.User
import org.springframework.stereotype.Repository

@Repository
class InMemoryUserRepository : UserRepository {

    private val userStorage: MutableMap<Long, User> = mutableMapOf()

    override fun createUser(user: User): User {
        val newId = userStorage.size.toLong()
        val created = User(newId, user)
        userStorage[newId] = created
        return created
    }

    override fun getUser(id: Long): User? {
        return userStorage[id]
    }

    override fun deleteUser(id: Long): Boolean {
        val deleted = userStorage.remove(id)
        return deleted != null
    }
}
