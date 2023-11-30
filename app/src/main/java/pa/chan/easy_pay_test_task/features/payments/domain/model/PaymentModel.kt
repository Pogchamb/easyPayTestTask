package pa.chan.easy_pay_test_task.features.payments.domain.model

import java.util.Date

data class PaymentModel(
    val id: Int,
    val title: String?,
    val amount: String?,
    val created: Date?
)
