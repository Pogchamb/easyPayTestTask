package pa.chan.easy_pay_test_task.features.auth.data

import pa.chan.easy_pay_test_task.features.auth.data.dto.LoginRequestDto
import pa.chan.easy_pay_test_task.features.auth.data.dto.LoginResponseDto
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    private val api: AuthApi
) {

    suspend fun loginUser(request: LoginRequestDto): LoginResponseDto {
        return api.loginUser(request)
    }

}