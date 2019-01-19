package work.zemu_them.android.houserecordapplication

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_money_regist.*
import android.app.Dialog
import android.support.v4.app.DialogFragment
import android.text.Editable
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import com.google.api.services.sheets.v4.model.ValueRange
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.xml.validation.Validator
import kotlin.collections.ArrayList

class MoneyRegistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_regist)

        val shopName = findViewById<AutoCompleteTextView>(R.id.boughtShopName)
        val getShopName = intent.getStringExtra("name")
        shopName.text = Editable.Factory.getInstance().newEditable(getShopName)

        //購入年月日の初期表示
        //初期表示は現在の年月日
        val calendar = Calendar.getInstance()
        val yearget = calendar.get(Calendar.YEAR)
        val monthget = calendar.get(Calendar.MONTH)
        val dayget = calendar.get(Calendar.DAY_OF_MONTH)

        val textView = findViewById<TextView>(R.id.boughtDateText)
        val date = String.format("${yearget}年${monthget + 1}月${dayget}日")
        textView.text = date

        boughtDateText.setOnClickListener { view ->
            val datePicker = DatePickerDialogFragment()
            datePicker.show(supportFragmentManager, "datePicker")

        }

        boughtRegistButton.setOnClickListener { view ->
        }

    }
}