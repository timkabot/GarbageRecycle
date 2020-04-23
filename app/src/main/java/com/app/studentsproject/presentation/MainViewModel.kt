package com.app.studentsproject.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.studentsproject.data.entity.ItemType
import com.app.studentsproject.data.entity.RecycleItem
import com.app.studentsproject.domain.ItemsInteractor

class MainViewModel(private val itemsInteractor: ItemsInteractor) : ViewModel() {
    fun getData(query: String) {
        val result: List<RecycleItem> = if(query.toIntOrNull() != null) {
            itemsInteractor.getItems( query.toLong())
        } else itemsInteractor.getItems(query)

        itemsLiveData.postValue(result)
    }
    fun getDescriptionForType(itemType: ItemType) = itemsInteractor.getDescriptionForType(itemType)
    val itemsLiveData = MutableLiveData< List<RecycleItem> >()

}