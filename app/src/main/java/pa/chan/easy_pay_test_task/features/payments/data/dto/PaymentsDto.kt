package pa.chan.easy_pay_test_task.features.payments.data.dto

import pa.chan.easy_pay_test_task.features.payments.domain.model.PaymentModel
import java.util.Date

data class PaymentsDto(
    val success: Boolean,
    val response: List<PaymentDto>
)

data class PaymentDto(
    val id: Int,
    val title: String?,
    val amount: String?,
    val created: String?
)

fun PaymentDto.toModel(): PaymentModel = PaymentModel(
    id,
    title,
    amount,
    created = created?.let { Date(it.toLong()) }
)




