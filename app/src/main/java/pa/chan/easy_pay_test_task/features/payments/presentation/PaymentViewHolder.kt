package pa.chan.easy_pay_test_task.features.payments.presentation

import androidx.recyclerview.widget.RecyclerView
import pa.chan.easy_pay_test_task.databinding.PaymentItemBinding
import pa.chan.easy_pay_test_task.features.payments.domain.model.PaymentModel
import java.text.SimpleDateFormat

class PaymentViewHolder(
    private val itemBinding: PaymentItemBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(paymentModel: PaymentModel) {
        if (paymentModel.amount.isNullOrEmpty()) {
            itemBinding.amount.text = "-"
        } else {
            itemBinding.amount.text = paymentModel.amount
        }
        itemBinding.title.text = paymentModel.title

        if (paymentModel.created != null) {
            itemBinding.createdTime.text =
                SimpleDateFormat("h:m a\nMMMM d, y").format(paymentModel.created)
        } else {
            itemBinding.createdTime.text = "-"
        }
    }

}