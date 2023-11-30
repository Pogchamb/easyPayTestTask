package pa.chan.easy_pay_test_task.features.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.ConnectionException
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.CustomerException
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.IncorrectCredentialsException
import pa.chan.easy_pay_test_task.features.auth.domain.LoginUseCase
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _loginLiveData: MutableLiveData<Boolean?> = MutableLiveData()
    val loginLiveData: LiveData<Boolean?>
        get() = _loginLiveData


    private val _exceptionLiveData: MutableLiveData<CustomerException> = MutableLiveData()
    val exceptionLiveData: LiveData<CustomerException>
        get() = _exceptionLiveData

    fun loginUser(login: String, password: String) {

        viewModelScope.launch {
            try {
                val response = loginUseCase(login, password)
                _loginLiveData.postValue(response)
            } catch (e: ConnectionException) {
                _exceptionLiveData.postValue(e)
            } catch (e: IncorrectCredentialsException) {
                _exceptionLiveData.postValue(e)
            }
        }


    }


}