package life.yalk.server.quokka.model

data class User(val id: Long?) {
    constructor() : this(null)
    constructor(id: Long?, user: User) : this(id)
}
