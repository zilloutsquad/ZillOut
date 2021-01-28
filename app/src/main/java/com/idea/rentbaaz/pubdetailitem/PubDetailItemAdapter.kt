package com.idea.rentbaaz.pubdetailitem

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.idea.rentbaaz.PubDetailItem

class PubDetailItemAdapter(val context: Context) : RecyclerView.Adapter<PubDetailItemViewHolder>() {

    val pubDetailItemList: MutableList<PubDetailItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PubDetailItemViewHolder {
        return PubDetailItemViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(context),
            viewType,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: PubDetailItemViewHolder, position: Int) {
        holder.bind(pubDetailItemList[position])
    }

    override fun getItemCount(): Int {
        return pubDetailItemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return pubDetailItemList[position].layoutId
    }

    fun setData(data: List<PubDetailItem>) {
        pubDetailItemList.clear()
        pubDetailItemList.addAll(data)
        notifyDataSetChanged()
    }
}