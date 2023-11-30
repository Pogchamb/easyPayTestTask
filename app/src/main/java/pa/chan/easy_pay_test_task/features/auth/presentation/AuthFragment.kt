package pa.chan.easy_pay_test_task.features.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.easy_pay_test_task.R
import pa.chan.easy_pay_test_task.databinding.FragmentAuthBinding
import pa.chan.easy_pay_test_task.features.auth.data.userExceptions.IncorrectCredentialsException
import pa.chan.easy_pay_test_task.features.auth.presentation.extension.finishAction
import pa.chan.easy_pay_test_task.features.auth.presentation.extension.startAction

@AndroidEntryPoint
class AuthFragment : Fragment() {

    private val vm: AuthViewModel by viewModels()

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val authBtn = binding?.authBtn
        val loginEditText = binding?.loginInputEditText
        val loginInputLayout = binding?.loginInputLayout
        val passwordEditText = binding?.passwordInputEditText
        val passwordInputLayout = binding?.passwordInputLayout



        vm.exceptionLiveData.observe(viewLifecycleOwner) {
            binding?.finishAction()
            if (it is IncorrectCredentialsException) {
                showInputLayoutError(loginInputLayout, it.errorMsg)
                showInputLayoutError(passwordInputLayout, it.errorMsg)
            }

            val snackBar =
                Snackbar.make(view, it.errorMsg, Snackbar.LENGTH_SHORT)

            snackBar.show()

        }

        vm.loginLiveData.observe(viewLifecycleOwner) {
            binding?.finishAction()
            findNavController().navigate(R.id.action_authFragment_to_paymentsFragment)

        }

        authBtn?.progressBtn?.setOnClickListener {
            val login = loginEditText?.text.toString()
            val password = passwordEditText?.text.toString()
            binding?.startAction()
            when {
                login.isEmpty() && password.isEmpty() -> {
                    showInputLayoutError(loginInputLayout, getString(R.string.invalid_username))
                    showInputLayoutError(passwordInputLayout, getString(R.string.invalid_password))
                    binding?.finishAction()
                }

                login.isEmpty() -> {
                    showInputLayoutError(loginInputLayout, getString(R.string.invalid_username))
                    binding?.finishAction()
                }

                password.isEmpty() -> {
                    passwordInputLayout?.isErrorEnabled = true
                    passwordInputLayout?.error = getString(R.string.invalid_password)
                    binding?.finishAction()
                }

                else -> {
                    vm.loginUser(login, password)
                }
            }

        }

        loginEditText?.addTextChangedListener {
            if (loginInputLayout?.isErrorEnabled == true && passwordInputLayout?.isErrorEnabled == true) {
                loginInputLayout.isErrorEnabled = false
                passwordInputLayout.isErrorEnabled = false
            }

            if (loginInputLayout?.isErrorEnabled == true) {
                loginInputLayout.isErrorEnabled = false
            }

            if (loginEditText.text.isNullOrEmpty()) {
                showInputLayoutError(loginInputLayout, getString(R.string.invalid_username))
            }
        }

        passwordEditText?.addTextChangedListener {
            if (loginInputLayout?.isErrorEnabled == true && passwordInputLayout?.isErrorEnabled == true) {
                loginInputLayout.isErrorEnabled = false
                passwordInputLayout.isErrorEnabled = false
            }

            if (passwordInputLayout?.isErrorEnabled == true) {
                passwordInputLayout.isErrorEnabled = false
            }

            if (passwordEditText.text.isNullOrEmpty()) {
                showInputLayoutError(passwordInputLayout, getString(R.string.invalid_password))
            }
        }



    }

    private fun showInputLayoutError(inputLayout: TextInputLayout?, msg: String) {
        inputLayout?.isErrorEnabled = true
        inputLayout?.error = msg
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}