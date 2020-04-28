package life.yalk.server.quokka.model

data class Message(val id: Long?, val sender: Long, val receiver: Long) {
    constructor(sender: Long, receiver: Long) : this(null, sender, receiver)
}
