package com.github.jhamin0511.reference

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ChangeCallback {

    private lateinit var text: TextView
    private lateinit var change: Button

    private var entity = ChangeEntity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)
        change = findViewById(R.id.change)

        entity.text = text.text.toString()

        change.setOnClickListener {
            val dialog = ChangeDialog.getInstance(entity)
            val ft = supportFragmentManager.beginTransaction()
            dialog.show(ft, ChangeDialog::class.java.simpleName)
        }
    }

    override fun onChange() {
        text.text = entity.text
    }

}
