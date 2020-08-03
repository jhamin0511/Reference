package com.github.jhamin0511.reference

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChangeActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 1000
    }

    private lateinit var edit: EditText
    private lateinit var save: Button
    private lateinit var entity: ChangeEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        entity = intent.getParcelableExtra("entity")!!

        setContentView(R.layout.change_activity)
        edit = findViewById(R.id.edit)
        save = findViewById(R.id.save)

        edit.setText(entity.getText())
        save.setOnClickListener {
            entity.setText(edit.text.toString())

            setResult(Activity.RESULT_OK)
            finish()
        }
    }

}
