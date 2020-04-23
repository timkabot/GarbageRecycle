package com.app.studentsproject.domain

import android.content.Context
import com.app.studentsproject.R
import com.app.studentsproject.codesOfType
import com.app.studentsproject.data.ItemsRepository
import com.app.studentsproject.data.entity.ItemType
import com.app.studentsproject.data.entity.ItemType.*
import java.sql.SQLOutput

class ItemsInteractor(private val itemsRepository: ItemsRepository, private val context: Context) {
    fun getItems(query: String) = itemsRepository.getItems().filter {
        it.name.toLowerCase().contains(query.toLowerCase())
                || query.toLowerCase().contains(it.name.toLowerCase())
    }

    fun getItems(query: Long) = itemsRepository.getItems().filter {
        val codes = codesOfType(it.type)
        codes.contains(query)
    }.map {
        val copy = it.copy()
        copy.image = "item${query}"
        copy
    }

    fun getDescriptionForType(itemType: ItemType): String {
        context.apply {
            return when (itemType) {
                PLASTIC  -> getString(R.string.plastic_description)
                POLYETHYLENE  -> getString(R.string.polyethilen_description)
                WASTEPAPER -> getString(R.string.wastepaper_descriptioh)
                METAL  -> getString(R.string.metal_description)
                GENERAL -> getString(R.string.general_description)
                TEXTILE -> getString(R.string.textile_description)
                BATTERY -> getString(R.string.battery_description)
                GLASS -> getString(R.string.glass_description)
            }
        }
    }


}