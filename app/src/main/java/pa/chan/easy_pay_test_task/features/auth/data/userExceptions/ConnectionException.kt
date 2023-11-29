package pa.chan.easy_pay_test_task.features.auth.data.userExceptions

object ConnectionException:Throwable(), CustomerException {
    override val errorMsg: String
        get() = "Check your internet connection"

}