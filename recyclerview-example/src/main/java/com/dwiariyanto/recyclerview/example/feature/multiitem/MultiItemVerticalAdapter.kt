/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 22:57                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.dwiariyanto.recyclerview.adapter.BaseRecyclerViewAdapter
import com.dwiariyanto.recyclerview.decoration.LinearSpanContentDecoration
import com.dwiariyanto.recyclerview.example.utils.dp
import javax.inject.Inject

class MultiItemVerticalAdapter
@Inject constructor(
		verticalItem: MultiItemVerticalItem
) : BaseRecyclerViewAdapter(
		verticalItem
) {
	
	override fun build(recyclerView: RecyclerView) {
		recyclerView.apply {
			addItemDecoration(LinearSpanContentDecoration(4f.dp))
			layoutManager = LinearLayoutManager(context)
		}
	}
}

