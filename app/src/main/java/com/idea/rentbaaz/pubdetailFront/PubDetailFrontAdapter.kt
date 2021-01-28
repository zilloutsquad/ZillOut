package com.idea.rentbaaz.pubdetailFront

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.idea.rentbaaz.PubDetailFrontItem
import com.idea.rentbaaz.PubItems
import com.idea.rentbaaz.R


class PubDetailFrontAdapter (val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_HEADER = 0
    private val TYPE_ITEM = 1
    val pubDetailFrontItemList : MutableList<PubItems> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType.equals(TYPE_ITEM))
            return PubDetailFrontViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_pub_detail_front, parent, false))
            return PubDetailHeaderViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_pub_name, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = pubDetailFrontItemList[position]
        if (holder is PubDetailFrontViewHolder && item is PubDetailFrontItem)
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_HEADER
        } else TYPE_ITEM
    }


    override fun getItemCount(): Int {
       return pubDetailFrontItemList.size
    }

    fun setData(data: List<PubItems>) {
        pubDetailFrontItemList.clear()
        pubDetailFrontItemList.addAll(data)
        notifyDataSetChanged()
    }
}