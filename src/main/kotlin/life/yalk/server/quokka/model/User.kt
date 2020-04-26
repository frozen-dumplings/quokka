package life.yalk.server.quokka.model

class User(id: Long?) {
    val id: Long? = id

    constructor(): this(null)
    constructor(id: Long?, user: User): this(id)
}
