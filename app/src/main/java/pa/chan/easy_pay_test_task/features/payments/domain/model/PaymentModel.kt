package pa.chan.easy_pay_test_task.features.payments.domain.model

data class PaymentModel(
    val id: Int,
    val title: String,
    val amount: String?,
    val created: Long
)
