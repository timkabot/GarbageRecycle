package com.app.studentsproject.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecycleItem(
    val name: String,
    var image: String = "",
    val type: ItemType,
    var resId: Int = 0
) : Parcelable