package com.example.listview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var hasilnya: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hasilnya = findViewById(R.id.result)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener { v ->
            when (v.id) {
                R.id.button -> tampilInput()
            }
        }
    }

    private fun tampilInput() {
        val li = LayoutInflater.from(this)
        val inputnya: View = li.inflate(R.layout.input_dialog, null)
        val dialognya: AlertDialog.Builder = AlertDialog.Builder(this)
        dialognya.setView(inputnya)
        val txtinput = inputnya.findViewById<View>(R.id.edittext) as EditText
        dialognya
            .setCancelable(false)
            .setPositiveButton("Ok") { dialog, _ ->
                hasilnya.text = txtinput.text.toString()
                dialog.dismiss()
            }
            .setNegativeButton("Batal"
            ) { dialog, which -> dialog.cancel() }
        dialognya.show()
    }
}