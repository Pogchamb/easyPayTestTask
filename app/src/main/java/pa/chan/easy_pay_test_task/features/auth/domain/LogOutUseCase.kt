package pa.chan.easy_pay_test_task.features.auth.domain

import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke() {
        authRepository.logOut()
    }

}