package com.app.studentsproject.ui.list

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.studentsproject.R
import com.app.studentsproject.data.entity.RecycleItem
import com.app.studentsproject.inflate
import com.app.studentsproject.ui.ItemClickListener

class ItemsAdapter(
    private var itemList: ArrayList<RecycleItem>,
    private val itemClickListener: ItemClickListener,
    private val context: Context) : RecyclerView.Adapter<ItemsAdapter.ItemHolder>() {

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(recycleItem: RecycleItem) {
            val itemName = itemView.findViewById<TextView>(R.id.itemNameText)
            val signImage = itemView.findViewById<ImageView>(R.id.sign)
            itemName.text = recycleItem.name

            if (recycleItem.image.isNotEmpty()) {
                val resID: Int = context.resources.getIdentifier(
                    recycleItem.image,
                    "drawable",
                    signImage.context.packageName
                )
                recycleItem.resId = resID
                signImage.setImageResource(resID)
                signImage.visibility = View.VISIBLE
            }
            else  signImage.visibility = View.GONE
            itemView.setOnClickListener { itemClickListener.onClick(recycleItem) }
        }
    }

    fun setData(itemList: List<RecycleItem>) {
        this.itemList.clear()
        this.itemList.addAll(itemList)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflatedView = parent.inflate(R.layout.card_recycleitem, false)
        return ItemHolder(inflatedView)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(itemList[position])
    }
}
