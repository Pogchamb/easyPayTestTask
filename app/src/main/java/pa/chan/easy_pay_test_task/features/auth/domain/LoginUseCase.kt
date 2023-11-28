package pa.chan.easy_pay_test_task.features.auth.domain

class LoginUseCase (private val authRepository: AuthRepository) {

    suspend operator fun invoke(login: String, password: String) {
        authRepository.loginUser(login, password)
    }

}