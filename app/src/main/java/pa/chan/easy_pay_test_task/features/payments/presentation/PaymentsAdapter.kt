package pa.chan.easy_pay_test_task.features.payments.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pa.chan.easy_pay_test_task.databinding.PaymentItemBinding
import pa.chan.easy_pay_test_task.features.payments.domain.model.PaymentModel

class PaymentsAdapter constructor(
    private val paymentsModelList: List<PaymentModel>
) : RecyclerView.Adapter<PaymentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val itemBinding =
            PaymentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaymentViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = paymentsModelList.size

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val paymentItem = paymentsModelList[position]
        holder.bind(paymentItem)
    }
}