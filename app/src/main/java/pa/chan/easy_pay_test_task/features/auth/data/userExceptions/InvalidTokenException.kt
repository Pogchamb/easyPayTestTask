package pa.chan.easy_pay_test_task.features.auth.data.userExceptions

object InvalidTokenException: CustomerException, Throwable() {
    override val errorMsg: String
        get() = "Invalid token"
}