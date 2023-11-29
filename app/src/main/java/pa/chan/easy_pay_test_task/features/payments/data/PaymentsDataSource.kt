package pa.chan.easy_pay_test_task.features.payments.data

import pa.chan.easy_pay_test_task.features.payments.data.dto.PaymentsDto
import javax.inject.Inject

class PaymentsDataSource @Inject constructor(
    private val paymentsApi: PaymentsApi
) {

    suspend fun getPayments(token: String): PaymentsDto {
        return paymentsApi.getPayments(token)
    }

}