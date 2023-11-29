package pa.chan.easy_pay_test_task.features.payments.domain

import pa.chan.easy_pay_test_task.features.payments.domain.model.PaymentModel
import javax.inject.Inject

class GetPaymentsUseCase @Inject constructor(
    private val paymentsRepository: PaymentsRepository
) {

    suspend operator fun invoke(): List<PaymentModel> {
        return paymentsRepository.getPaymentsList()
    }

}