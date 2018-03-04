/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, March 04, 2018 at 21:51                                                                *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.loadmore

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.dwiariyanto.recyclerview.adapter.BaseRecyclerViewAdapter
import com.dwiariyanto.recyclerview.decoration.ItemDecoration
import com.dwiariyanto.recyclerview.example.utils.dp
import javax.inject.Inject

class LoadMoreAdapter
@Inject constructor(
		loadMoreItem: LoadMoreItem
) : BaseRecyclerViewAdapter(
		loadMoreItem
) {
	
	override fun build(recyclerView: RecyclerView) {
		recyclerView.apply {
			addItemDecoration(ItemDecoration(8.dp))
			layoutManager = LinearLayoutManager(context)
		}
		enableLoadMore()
	}
}
