package com.idea.rentbaaz.pubdetailitem

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.idea.rentbaaz.BR

import com.idea.rentbaaz.PubDetailItem

class PubDetailItemViewHolder(
    val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PubDetailItem) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}