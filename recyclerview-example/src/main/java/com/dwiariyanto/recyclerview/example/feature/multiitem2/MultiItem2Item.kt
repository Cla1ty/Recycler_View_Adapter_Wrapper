/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Wednesday, March 28, 2018 at 22:16                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem2

import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.recyclerview.example.R
import kotlinx.android.synthetic.main.multi_item2_content_item.view.*
import javax.inject.Inject

class MultiItem2HeaderItem
@Inject constructor() : BaseItemView<MultiItem2HeaderData>(
        MultiItem2HeaderData::class.java,
        R.layout.multi_item2_header_item
)

class MultiItem2ContentItem
@Inject constructor() : BaseItemView<MultiItem2ContentData>(
        MultiItem2ContentData::class.java,
        R.layout.multi_item2_content_item
)
{
    override fun onBind(holder: RecyclerViewHolder, data: MultiItem2ContentData)
    {
        holder.itemView.apply {
            content1.text = data.content1
            content2.text = data.content2
            content3.text = data.content3
        }
    }
}