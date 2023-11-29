package pa.chan.easy_pay_test_task.features.payments.data

import pa.chan.easy_pay_test_task.features.payments.data.dto.PaymentsDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface PaymentsApi {

    @Headers(
        "app-key: 12345",
        "v: 1"
    )
    @GET ("payments")
    suspend fun getPayments(@Header("token") token: String): PaymentsDto


}