package pa.chan.easy_pay_test_task.features.auth.data.userExceptions

class ConnectionException(private val msg: String) : UserError, Throwable() {
    override val errorMsg: String
        get() = msg

}