package work.zemu_them.android.houserecordapplication

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import android.widget.TextView
import java.util.*

class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val yearget = calendar.get(Calendar.YEAR)
        val monthget = calendar.get(Calendar.MONTH)
        val dayget = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, this, yearget, monthget, dayget)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {

        val textView = activity!!.findViewById(R.id.boughtDateText) as TextView
        val date = String.format("${year}年${month+1}月${day}日")
        textView.text = date
    }
}