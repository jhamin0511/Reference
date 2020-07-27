package com.github.jhamin0511.reference


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ChangeCallback {

    private lateinit var text: TextView
    private lateinit var dialog: Button
    private lateinit var activity: Button

    private var entity = ChangeEntity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text)
        dialog = findViewById(R.id.dialog)
        activity = findViewById(R.id.activity)

        entity.text = text.text.toString()
        Log.i(this::class.simpleName, "entity ${System.identityHashCode(entity)}")

        dialog.setOnClickListener {
            val dialog = ChangeDialog.getInstance(entity)
            val ft = supportFragmentManager.beginTransaction()
            dialog.show(ft, ChangeDialog::class.java.simpleName)
        }
        activity.setOnClickListener {
            val intent = Intent(this, ChangeActivity::class.java).apply {
                putExtra("entity", entity)
            }
            startActivityForResult(intent, ChangeActivity.REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                ChangeActivity.REQUEST_CODE -> {
                    text.text = entity.text
                }
            }
        }
    }

    override fun onChange() {
        text.text = entity.text
    }

}
