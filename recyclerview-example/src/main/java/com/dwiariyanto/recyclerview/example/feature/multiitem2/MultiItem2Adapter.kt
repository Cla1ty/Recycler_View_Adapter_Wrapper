/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Wednesday, March 28, 2018 at 22:30                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem2

import android.support.v7.widget.RecyclerView
import com.dwiariyanto.recyclerview.adapter.BaseRecyclerViewAdapter
import com.dwiariyanto.recyclerview.example.utils.dp
import com.dwiariyanto.recyclerview.extension.erViDecor
import com.dwiariyanto.recyclerview.extension.erViManager
import javax.inject.Inject

class MultiItem2Adapter
@Inject constructor(
        val headerItem: MultiItem2HeaderItem,
        val contentItem: MultiItem2ContentItem
) : BaseRecyclerViewAdapter(
        headerItem,
        contentItem
)
{
    override fun build(recyclerView: RecyclerView)
    {
        recyclerView.apply {
            erViDecor { erViExtraBottom = 10.dp }
            erViManager { }
            isNestedScrollingEnabled = false
        }
    }
}
