package user

interface UserReader {
    fun getUser(id: Long): User
}