package com.app.studentsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.app.studentsproject.data.entity.ItemType

fun codesOfType(type: ItemType): List<Long>{
    return when(type){
        ItemType.PLASTIC -> listOf(1,3,5,6,7,9)
        ItemType.POLYETHYLENE -> listOf(2,4)
        ItemType.WASTEPAPER -> listOf(20,21,22,23,80)
        ItemType.METAL -> listOf(40,41)
        ItemType.GENERAL -> listOf(81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97)
        ItemType.TEXTILE -> listOf(60,61)
        ItemType.BATTERY -> listOf(8,19,10,11,12,13,14)
        ItemType.GLASS -> listOf(98,70,71,72,73,74,75,76,77,78,79)
    }
}

//      Extensions part
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}