package com.example.weightoptions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import android.view.MenuInflater as MenuInflater1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bmi : TextView = findViewById(R.id.bmiResult)

        val convertButton: Button = findViewById(R.id.convertButton)
        val weight: EditText = findViewById(R.id.initialWeight)
        val spinnerVal: Spinner = findViewById(R.id.weightSelect)
        val result: TextView = findViewById(R.id.resultTextView)
        var flag : String = "sum"
        var options = arrayOf("lbs","kg")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        convertButton.setOnClickListener {
            val weight = weight.text.toString().toDoubleOrNull() ?: return@setOnClickListener
            val unit = flag

            val convertedWeight = when (unit) {
                "kg" -> weight * 2.20462
                "lbs" -> weight * 0.453592
                else -> return@setOnClickListener
            }

            result.text = String.format("%.2f %s = %.2f %s", weight, unit, convertedWeight, if (unit == "kg") "lbs" else "kg")
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu to use in the action bar
     val inflater = menuInflater
     inflater.inflate(R.menu.weight_menu, menu)
     return super.onCreateOptionsMenu(menu)
     }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var dialog_var = BmiDialog()
        var rangesdialog = BmiStandardsDialog()
        when(item.itemId){
            R.id.item1 -> dialog_var.show(supportFragmentManager, "bmi Dialog")
            R.id.item2 -> rangesdialog.show(supportFragmentManager, "ranges Dialog")
        }
        return true;
    }


    fun receiveFeedback(feedback: String){
        val bmi : TextView = findViewById(R.id.bmiResult)
        bmi.text = feedback;
    }
}
