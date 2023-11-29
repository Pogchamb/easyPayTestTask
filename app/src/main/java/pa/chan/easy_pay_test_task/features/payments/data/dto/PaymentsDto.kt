package pa.chan.easy_pay_test_task.features.payments.data.dto

import pa.chan.easy_pay_test_task.features.payments.domain.model.PaymentModel

data class PaymentsDto(
    val success: Boolean,
    val response: List<PaymentDto>
)

data class PaymentDto(
    val id: Int,
    val title: String,
    val amount: Any?,
    val created: Long
)

fun PaymentDto.toModel(): PaymentModel = PaymentModel(
    id,
    title,
    amount = if (amount == null) {
        "amount is not exist"
    } else if (amount.toString().isEmpty()) {
        "amount is not exist"
    } else {
        amount.toString()
    },
    created
)




