package life.yalk.server.quokka.model

class Message(id: Long?, sender: Long, receiver: Long) {
    val id: Long? = id
    val sender: Long = sender
    val receiver: Long = receiver

    constructor(sender: Long, receiver: Long): this(null, sender, receiver)
}
