package pa.chan.easy_pay_test_task.features.payments.data

import pa.chan.easy_pay_test_task.features.auth.data.PrefDataSource
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.ConnectionException
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.InvalidTokenException
import pa.chan.easy_pay_test_task.features.payments.data.dto.toModel
import pa.chan.easy_pay_test_task.features.payments.domain.PaymentsRepository
import pa.chan.easy_pay_test_task.features.payments.domain.model.PaymentModel
import javax.inject.Inject

class PaymentsRepositoryImpl @Inject constructor(
    private val prefDataSource: PrefDataSource,
    private val paymentsDataSource: PaymentsDataSource
) : PaymentsRepository {
    override suspend fun getPaymentsList(): List<PaymentModel> {
        try {
            val token = prefDataSource.getUserToken()
            if (!token.isNullOrEmpty()) {
                val payments = paymentsDataSource.getPayments(token)
                return if (payments.success == true) {
                    payments.response.map {
                        it.toModel()
                    }
                } else {
                    throw InvalidTokenException
                }
            }
            return emptyList()
        } catch (e: Exception) {
            throw ConnectionException
        }
    }


}