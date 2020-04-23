package com.app.studentsproject.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.studentsproject.R
import com.app.studentsproject.codesOfType
import com.app.studentsproject.data.entity.RecycleItem
import com.app.studentsproject.presentation.MainViewModel
import kotlinx.android.synthetic.main.activity_item.*
import org.koin.android.viewmodel.ext.android.viewModel


class ItemDescriptionActivity : AppCompatActivity() {
    private val mainVM: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        initInfo()
        initListeners()

    }

    private fun initListeners(){
        showOnMapButton.setOnClickListener {
            val mapIntent = Intent(this, MapActivity::class.java)
            startActivity(mapIntent)
        }
    }
    private fun initInfo(){
        intent?.apply {
            if(extras!= null){
                val recycleItem = extras!!["item"] as RecycleItem

                if(recycleItem.resId!=0){
                    sign.setImageResource(recycleItem.resId)
                }
                else {
                    val resID: Int = applicationContext.resources.getIdentifier(
                        "item" + codesOfType(recycleItem.type)[0].toString(),
                        "drawable",
                        applicationContext.packageName
                    )
                    sign.setImageResource(resID)
                }
                titleItem.text = recycleItem.name
                description.text = mainVM.getDescriptionForType(recycleItem.type)
            }
        }

    }
}