package pa.chan.easy_pay_test_task.features.auth.presentation.extension

import android.view.View
import pa.chan.easy_pay_test_task.databinding.FragmentAuthBinding


fun FragmentAuthBinding.startAction() {
    this.authBtn.progressBar.visibility = View.VISIBLE
    this.authBtn.btnText.visibility = View.GONE
}

fun FragmentAuthBinding.finishAction() {
    this.authBtn.progressBar.visibility = View.GONE
    this.authBtn.btnText.visibility = View.VISIBLE
}