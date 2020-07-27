package com.github.jhamin0511.reference

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChangeEntity(
    var text: String = ""
) : Parcelable
