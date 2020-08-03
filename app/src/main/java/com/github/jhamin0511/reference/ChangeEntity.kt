package com.github.jhamin0511.reference

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Observable

@Parcelize
data class ChangeEntity(
    private var text: String = ""
) : Observable(), Parcelable {

    fun getText() = text

    fun setText(value: String) {
        text = value
        setChanged()
        notifyObservers()
    }

}
