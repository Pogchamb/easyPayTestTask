package pa.chan.easy_pay_test_task.features.payments.domain

import pa.chan.easy_pay_test_task.features.payments.domain.model.PaymentModel

interface PaymentsRepository {

    suspend fun getPaymentsList(): List<PaymentModel>

}