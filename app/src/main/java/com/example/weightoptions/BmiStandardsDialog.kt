package com.example.weightoptions
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class BmiStandardsDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bmiranges_dialog, container, false)

        val closeButton = view.findViewById<Button>(R.id.btn_close)
//        val imageView = view.findViewById<ImageView>(R.id.image_view)
//        imageView.setImageResource(R.drawable.bmi_ranges2_background)

        closeButton.setOnClickListener {
            dismiss()
        }

        return view
    }
}
