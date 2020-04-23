package com.app.studentsproject.data

import com.app.studentsproject.data.entity.ItemType
import com.app.studentsproject.data.entity.RecycleItem

class ItemsRepository {
    private val basicItems = arrayListOf( RecycleItem("Пластик", type = ItemType.PLASTIC),
    RecycleItem("Полиэтилен", type = ItemType.POLYETHYLENE),
    RecycleItem("Макулатура", type = ItemType.WASTEPAPER),
    RecycleItem("Металл", type = ItemType.METAL),
    RecycleItem("Стекло", type = ItemType.GLASS),
    RecycleItem("Общий бак", type = ItemType.GENERAL),
    RecycleItem("Батарейки", type = ItemType.BATTERY))

    fun getItems() : List<RecycleItem> {
        return basicItems
    }
}