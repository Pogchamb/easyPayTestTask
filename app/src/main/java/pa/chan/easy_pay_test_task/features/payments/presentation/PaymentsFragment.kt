package pa.chan.easy_pay_test_task.features.payments.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.easy_pay_test_task.R
import pa.chan.easy_pay_test_task.databinding.FragmentPaymentsBinding
import pa.chan.easy_pay_test_task.features.payments.presentation.extension.failedAction
import pa.chan.easy_pay_test_task.features.payments.presentation.extension.finishAction
import pa.chan.easy_pay_test_task.features.payments.presentation.extension.startAction
import pa.chan.easy_pay_test_task.features.payments.presentation.extension.successAction

@AndroidEntryPoint
class PaymentsFragment : Fragment() {

    private val vm: PaymentsViewModel by viewModels()

    private var _binding: FragmentPaymentsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.paymentRecycler?.layoutManager = LinearLayoutManager(requireContext())

        vm.paymentsLiveData.observe(viewLifecycleOwner) {
            binding?.finishAction()
            binding?.successAction()
            binding?.paymentRecycler?.adapter = PaymentsAdapter(it)
        }

        vm.exceptionLiveData.observe(viewLifecycleOwner) {
            binding?.finishAction()
            binding?.failedAction()
            val snackBar =
                Snackbar.make(view, it.errorMsg, Snackbar.LENGTH_SHORT)

            snackBar.show()
        }

        vm.logoutLiveData.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_paymentsFragment_to_authFragment)
        }

        binding?.toolbar?.logOut?.setOnClickListener {
            vm.logout()
        }

        binding?.retryBtn?.progressBtn?.setOnClickListener {
            binding?.startAction()
            vm.fetchPayments()
        }

        vm.fetchPayments()

    }

}