package pa.chan.easy_pay_test_task.features.auth.data.userExceptions

object ConnectionException: UserError, Throwable() {
    override val errorMsg: String
        get() = "Check your internet connection"

}