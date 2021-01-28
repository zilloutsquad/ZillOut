package com.idea.rentbaaz

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.idea.rentbaaz.databinding.LayoutPubCardBinding

class DiscoveryAdapter(val context : Context) : RecyclerView.Adapter<DiscoveryViewHolder>(){
    private val pubs : MutableList<PubItem> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoveryViewHolder {
        return DiscoveryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.layout_pub_card,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return pubs.size
    }

    override fun onBindViewHolder(holder: DiscoveryViewHolder, position: Int) {
        holder.bind(pubs[position])
    }

    fun setData(pubs : List<PubItem>) {
        this.pubs.clear()
        this.pubs.addAll(pubs)
        notifyDataSetChanged()
    }

}


class DiscoveryViewHolder(private val binding: LayoutPubCardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PubItem) {
        binding.pub = item
        binding.executePendingBindings()
    }

}