/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 23:02                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.dwiariyanto.recyclerview.adapter.BaseRecyclerViewAdapter
import com.dwiariyanto.recyclerview.decoration.ItemDecoration
import com.dwiariyanto.recyclerview.example.utils.dp
import javax.inject.Inject

class MultiItemHorizontalAdapter
@Inject constructor(
		horizontalItem: MultiItemHorizontalItem,
		horizontalMoreItem: MultiItemHorizontalMoreItem
) : BaseRecyclerViewAdapter(
		horizontalItem,
		horizontalMoreItem
) {
	
	override fun build(recyclerView: RecyclerView) {
		recyclerView.apply {
			addItemDecoration(ItemDecoration(8.dp))
			layoutManager = LinearLayoutManager(
					context,
					LinearLayout.HORIZONTAL,
					false
			)
		}
	}
}


