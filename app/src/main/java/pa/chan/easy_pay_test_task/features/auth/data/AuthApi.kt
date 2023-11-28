package pa.chan.easy_pay_test_task.features.auth.data

import pa.chan.easy_pay_test_task.features.auth.data.dto.LoginRequestDto
import pa.chan.easy_pay_test_task.features.auth.data.dto.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {
    @Headers(
        "app-key: 12345",
        "v: 1"
    )
    @POST("login")
    suspend fun loginUser(@Body requestDto: LoginRequestDto): LoginResponseDto

}