package com.example.weightoptions
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class BmiDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setTitle("BMI Calculator")
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bmi_dialog, container, false)

        val heightInput = view.findViewById<EditText>(R.id.height_edit_text)
        val weightInput = view.findViewById<EditText>(R.id.weight_edit_text)
        val calculateButton = view.findViewById<Button>(R.id.calculate_button)


        calculateButton.setOnClickListener {
            val height = heightInput.text.toString().toDoubleOrNull()
            val weight = weightInput.text.toString().toDoubleOrNull()

            if (height != null && weight != null) {
                val bmi = calculateBmi(height, weight)
                val resultString = "Your BMI is %.2f".format(bmi)


                val m1:MainActivity = getActivity() as MainActivity
                m1.receiveFeedback(resultString.toString())
            }

            dismiss()
        }

        return view
    }

    private fun calculateBmi(height: Double, weight: Double): Double {
        val heightInMeters = height / 100.0
        return weight / (heightInMeters * heightInMeters)
    }
}
