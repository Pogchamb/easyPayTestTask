package pa.chan.easy_pay_test_task.features.auth.data.userExceptions

object MissingAppKeyException : CustomerException, Throwable() {
    override val errorMsg: String
        get() = "App key"
}