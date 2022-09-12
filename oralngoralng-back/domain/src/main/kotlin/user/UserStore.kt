package user


interface UserStore {
    fun store(user: User): User
    fun delete(id: Long)
}