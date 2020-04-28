package life.yalk.server.quokka.service

import life.yalk.server.quokka.model.User
import life.yalk.server.quokka.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired val userRepository: UserRepository) {

    fun createUser(user: User): User {
        return userRepository.createUser(user)
    }

    fun getUser(id: Long): User? {
        return userRepository.getUser(id)
    }

    fun deleteUser(id: Long): Boolean {
        return userRepository.deleteUser(id)
    }
}
