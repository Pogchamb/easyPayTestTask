package pa.chan.easy_pay_test_task.features.payments.presentation.extension

import android.view.View
import pa.chan.easy_pay_test_task.databinding.FragmentPaymentsBinding

fun FragmentPaymentsBinding.failedAction() {
    this.retryBtn.progressBtn.visibility = View.VISIBLE
}

fun FragmentPaymentsBinding.successAction() {
    this.retryBtn.progressBtn.visibility = View.GONE
}

fun FragmentPaymentsBinding.startAction() {
    this.retryBtn.progressBar.visibility = View.VISIBLE
    this.retryBtn.btnText.visibility = View.GONE
}

fun FragmentPaymentsBinding.finishAction() {
    this.retryBtn.progressBar.visibility = View.GONE
    this.retryBtn.btnText.visibility = View.VISIBLE
}