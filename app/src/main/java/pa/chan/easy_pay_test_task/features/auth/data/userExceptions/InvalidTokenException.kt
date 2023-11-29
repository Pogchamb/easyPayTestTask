package pa.chan.easy_pay_test_task.features.auth.data.userExceptions

class InvalidTokenException(private val msg: String) : CustomerException, Throwable() {
    override val errorMsg: String
        get() = msg
}