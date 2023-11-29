package pa.chan.easy_pay_test_task.features.payments.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pa.chan.easy_pay_test_task.features.payments.data.PaymentsApi
import pa.chan.easy_pay_test_task.features.payments.data.PaymentsRepositoryImpl
import pa.chan.easy_pay_test_task.features.payments.domain.PaymentsRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PaymentsModule {
    companion object {
        @Provides
        @Singleton
        fun providePaymentsApi(retrofit: Retrofit): PaymentsApi =
            retrofit.create(PaymentsApi::class.java)
    }

    @Binds
    abstract fun bindPaymentsRepository(paymentsRepositoryImpl: PaymentsRepositoryImpl): PaymentsRepository
}