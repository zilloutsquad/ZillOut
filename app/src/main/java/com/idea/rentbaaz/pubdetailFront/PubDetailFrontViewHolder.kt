package com.idea.rentbaaz.pubdetailFront

import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idea.rentbaaz.PubDetailFrontItem
import com.idea.rentbaaz.databinding.LayoutPubDetailFrontBinding

class PubDetailFrontViewHolder(
    val binding: LayoutPubDetailFrontBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PubDetailFrontItem) {
        binding.childRecyclerView.adapter = item.adapter
        binding.childRecyclerView.layoutManager = when (item.orientation) {
            "Horizontal" -> LinearLayoutManager(
                binding.root.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )

            "Vertical" ->  LinearLayoutManager(
                binding.root.context
            )

            else -> GridLayoutManager(
                binding.root.context,
                2
            )
        }

        binding.detailName.text = item.detailName
    }
}