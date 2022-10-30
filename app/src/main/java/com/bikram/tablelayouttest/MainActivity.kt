package com.bikram.tablelayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val androidVersionEditText = findViewById<EditText>(R.id.android_version_edit_text)
        val androidCodeNameEditText = findViewById<EditText>(R.id.android_code_name_edit_text)
        val addButton = findViewById<Button>(R.id.add_button)
        val table = findViewById<TableLayout>(R.id.table)

        addButton.setOnClickListener {
            if (androidVersionEditText.text.isNotEmpty() && androidCodeNameEditText.text.isNotEmpty()) {
                val tableRow = TableRow(applicationContext)
                val layoutParams = TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
                tableRow.layoutParams = layoutParams
                val androidVersion = TextView(applicationContext)
                androidVersion.layoutParams = TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1f
                )
                androidVersion.text = androidVersionEditText.text
                val androidCodeName = TextView(applicationContext)
                androidCodeName.layoutParams = TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1f
                )
                androidCodeName.text = androidCodeNameEditText.text
                tableRow.addView(androidVersion)
                tableRow.addView(androidCodeName)
                table.addView(tableRow)
                androidVersionEditText.text.clear()
                androidCodeNameEditText.text.clear()
            }
        }
    }
}