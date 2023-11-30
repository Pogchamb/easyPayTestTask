package pa.chan.easy_pay_test_task.features.payments.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.ConnectionException
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.CustomerException
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.InvalidTokenException
import pa.chan.easy_pay_test_task.features.auth.domain.LogOutUseCase
import pa.chan.easy_pay_test_task.features.payments.domain.GetPaymentsUseCase
import pa.chan.easy_pay_test_task.features.payments.domain.model.PaymentModel
import javax.inject.Inject

@HiltViewModel
class PaymentsViewModel @Inject constructor(
    private val logOutUseCase: LogOutUseCase,
    private val getPaymentsUseCase: GetPaymentsUseCase
) : ViewModel() {
    private val _paymentsLiveData: MutableLiveData<List<PaymentModel>> = MutableLiveData()
    val paymentsLiveData: LiveData<List<PaymentModel>>
        get() = _paymentsLiveData


    private val _exceptionLiveData: MutableLiveData<CustomerException> = MutableLiveData()
    val exceptionLiveData: LiveData<CustomerException>
        get() = _exceptionLiveData

    private val _logoutLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val logoutLiveData: LiveData<Boolean>
        get() = _logoutLiveData


    fun logout() {
        viewModelScope.launch {
            logOutUseCase()
            _logoutLiveData.postValue(true)
        }
    }

    fun fetchPayments() {
        viewModelScope.launch {
            try {
                _paymentsLiveData.postValue(getPaymentsUseCase().orEmpty())
            } catch (e: ConnectionException) {
                _exceptionLiveData.postValue(e)
            } catch (e: InvalidTokenException) {
                _exceptionLiveData.postValue(e)
            }
        }
    }


}