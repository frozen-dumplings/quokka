package life.yalk.server.quokka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuokkaApplication

fun main(args: Array<String>) {
    runApplication<QuokkaApplication>(*args)
}
