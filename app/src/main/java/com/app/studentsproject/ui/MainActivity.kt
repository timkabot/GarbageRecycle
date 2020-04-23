package com.app.studentsproject.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.studentsproject.R
import com.app.studentsproject.data.entity.ItemType
import com.app.studentsproject.data.entity.RecycleItem
import com.app.studentsproject.presentation.MainViewModel
import com.app.studentsproject.ui.list.ItemsAdapter
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), MaterialSearchBar.OnSearchActionListener {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ItemsAdapter

    private lateinit var myItemClickListener: ItemClickListener

    private val mainVM: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
        initRecycler()
    }

    private fun initRecycler() {
        linearLayoutManager = LinearLayoutManager(this)
        itemsRecycler.layoutManager = linearLayoutManager

        adapter = ItemsAdapter(
            arrayListOf(),
            myItemClickListener,
            applicationContext
        )

        itemsRecycler.adapter = adapter
    }

    override fun onButtonClicked(buttonCode: Int) {}

    override fun onSearchStateChanged(enabled: Boolean) {}


    override fun onSearchConfirmed(text: CharSequence?) {
        mainVM.getData(text.toString())
    }

    private fun initListeners() {
        mainVM.itemsLiveData.observe(this,
            Observer { data -> data?.let { adapter.setData(data) } })

        questionButton.setOnClickListener {
            startActivity(Intent(this, QuestionActivity::class.java))
        }

        searchView.setOnSearchActionListener(this)

        myItemClickListener = object : ItemClickListener {
            override fun onClick(recycleItem: RecycleItem) {
                startActivity(Intent(applicationContext, ItemDescriptionActivity::class.java)
                    .apply { putExtra("item", recycleItem) })
            }
        }
    }
}

interface ItemClickListener {
    fun onClick(recycleItem: RecycleItem)
}