package pa.chan.easy_pay_test_task.features.auth.data.userExceptions

object IncorrectCredentialsException:Throwable(), CustomerException {
    override val errorMsg: String
        get() = "incorrect credentials"
}