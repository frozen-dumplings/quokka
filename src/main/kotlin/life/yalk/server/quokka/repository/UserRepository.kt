package life.yalk.server.quokka.repository

import life.yalk.server.quokka.model.User

interface UserRepository {
    fun createUser(user: User): User
    fun getUser(id: Long): User?
    fun deleteUser(id: Long): Boolean
}
