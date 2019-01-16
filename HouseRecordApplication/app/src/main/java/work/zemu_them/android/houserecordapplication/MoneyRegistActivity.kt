package work.zemu_them.android.houserecordapplication

import android.app.DatePickerDialog
import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.icu.util.Calendar
import android.widget.DatePicker

class MoneyRegistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_regist)

        // 日付設定ダイアログの作成
        val datePickerDialog = DatePickerDialog(
            this@MoneyRegistActivity
        )
        val datePicker = datePickerDialog.datePicker
        // 日付設定ダイアログの表示
        datePickerDialog.show()

    }
}
