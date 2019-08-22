package com.example.ass4_ui

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mPickTimeBtn = findViewById<Button>(R.id.pickDateBtn)
        val textView = findViewById<TextView>(R.id.dateTv)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        mPickTimeBtn.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                textView.setText("" + dayOfMonth + "/" + month + "/" + year)
            }, year, month, day)
            dpd.show()

        }
    }

    fun register(view: View) {
        var radioGroup: RadioGroup= findViewById(R.id.radioGroup)
        var selectedId: Int= radioGroup.checkedRadioButtonId;
        var radioButton: RadioButton= findViewById(selectedId);
        text_show.text =    "Name: ${edit_name.text}" +
                "\nPassword: ${edit_password.text}" +
                "\nGender: ${radioButton.text}" +
                "\nE-mail: ${edit_email.text}" +
                "\nBirthday: ${dateTv.text}"
    }

    fun reset(view: View) {
        edit_name.text.clear()
        edit_password.text.clear()
        radioGroup.clearCheck()
        edit_email.text.clear()
        dateTv.text = "mm / dd / yy"
        text_show.text = "Show Information"
    }
}
