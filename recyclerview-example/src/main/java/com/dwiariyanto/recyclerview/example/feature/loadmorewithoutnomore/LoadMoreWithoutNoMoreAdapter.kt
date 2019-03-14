/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2019. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Friday, March 09, 2018 at 00:14                                                                *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.loadmorewithoutnomore

import android.support.v7.widget.RecyclerView
import com.dwiariyanto.recyclerview.R
import com.dwiariyanto.recyclerview.adapter.BaseRecyclerViewAdapter
import com.dwiariyanto.recyclerview.example.utils.dp
import com.dwiariyanto.recyclerview.extension.erViDecor
import com.dwiariyanto.recyclerview.extension.erViManager
import javax.inject.Inject

class LoadMoreWithoutNoMoreAdapter
@Inject constructor(
        loadMoreWithoutNoMoreItem: LoadMoreWithoutNoMoreItem
) : BaseRecyclerViewAdapter(
        loadMoreWithoutNoMoreItem
)
{

    override fun build(recyclerView: RecyclerView)
    {
        recyclerView.apply {
            erViDecor { erViSpanSize = 8.dp }
            erViManager { }
        }
        enableLoadMore(
                noMoreLayoutId = R.layout.item_no_more_empty
        )
    }
}
