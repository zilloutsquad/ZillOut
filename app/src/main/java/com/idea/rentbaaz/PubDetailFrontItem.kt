package com.idea.rentbaaz

import androidx.recyclerview.widget.RecyclerView
import com.idea.rentbaaz.pubdetailitem.PubDetailItemViewHolder

sealed class PubItems
data class PubDetailFrontItem(
    val item: List<PubDetailItem>,
    val adapter: RecyclerView.Adapter<PubDetailItemViewHolder>,
    val detailName: String,
    val orientation: String
) : PubItems()

data class PubHeader(
    val pubName: String,
    val pubArea: String
) : PubItems()
