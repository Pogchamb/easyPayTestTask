package pa.chan.easy_pay_test_task.features.auth.data.dto

import com.google.gson.annotations.SerializedName

data class LoginResponseDto(
    val success: Boolean,
    val response: TokenDto,
    val error: ErrorDto
)

data class TokenDto(
    val token: String
)

data class ErrorDto(
    @SerializedName("error_code")
    val errorCode: Int,
    @SerializedName("error_msg")
    val errorMsg: String
)
