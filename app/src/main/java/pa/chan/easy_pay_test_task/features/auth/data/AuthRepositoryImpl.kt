package pa.chan.easy_pay_test_task.features.auth.data

import pa.chan.easy_pay_test_task.features.auth.data.dto.LoginRequestDto
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.ConnectionException
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.IncorrectCredentialsException
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.MissingAppKeyException
import pa.chan.easy_pay_test_task.features.auth.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val prefDataSource: PrefDataSource
) : AuthRepository {
    override suspend fun logOut() {
        prefDataSource.clearAll()
    }

    override suspend fun loginUser(login: String, password: String): Boolean {
        return try {
            val loginResponse = authDataSource.loginUser(LoginRequestDto(login, password))
            if (!loginResponse.success)  throw IncorrectCredentialsException

            prefDataSource.setUserToken(loginResponse.response.token)
             true
        } catch (e: MissingAppKeyException) {
            throw MissingAppKeyException
        } catch (e: IncorrectCredentialsException) {
            throw e
        } catch (e: Exception) {
            throw ConnectionException
        }
    }
}