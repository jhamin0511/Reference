package com.github.jhamin0511.reference

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ChangeDialog : DialogFragment() {

    companion object {
        fun getInstance(entity: ChangeEntity): DialogFragment {
            val bundle = Bundle().apply {
                putParcelable("entity", entity)
            }

            return ChangeDialog().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var editView: EditText
    private lateinit var entity: ChangeEntity
    private lateinit var callback: ChangeCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)

        callback = context as ChangeCallback

        entity = arguments?.getParcelable("entity")!!
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = requireActivity()
        val inflater = context.layoutInflater
        val view = inflater.inflate(R.layout.change_dialog, null, false)

        editView = view.findViewById(R.id.edit)
        editView.setText(entity.text)

        return AlertDialog.Builder(requireContext())
            .setView(view)
            .setPositiveButton(android.R.string.ok) { dialog, which ->
                entity.text = editView.text.toString()
                callback.onChange()
            }.create()
    }

}
