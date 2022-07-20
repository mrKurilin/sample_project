import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

fun Fragment.showToast(@StringRes messageRes: Int) {
    showToast(requireContext(), messageRes)
}

fun AppCompatActivity.showToast(@StringRes messageRes: Int) {
    showToast(this, messageRes)
}

fun RecyclerView.ViewHolder.showToast(message: String) {
    showToast(itemView.context, messageString = message)
}

private fun showToast(
    context: Context,
    @StringRes messageRes: Int? = null,
    messageString: String? = null
) {
    if (messageString == null) {
        Toast.makeText(context, messageRes!!, Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, messageString, Toast.LENGTH_SHORT).show()
    }
}