package pa.chan.easy_pay_test_task.features.auth.domain

interface AuthRepository {
    suspend fun logOut()

    suspend fun loginUser(login: String, password: String): Boolean

}