/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2017. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Friday, July 07, 2017                                                                          *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.scrollListener

import android.support.v7.widget.RecyclerView

class SimpleLoadMore(private val loadMore: () -> Unit) : RecyclerView.OnScrollListener() {
	fun setupWithRecyclerView(recyclerView: RecyclerView) {
		recyclerView.addOnScrollListener(this)
	}
	
	override fun onScrolled(
			recyclerView: RecyclerView?,
			dx: Int,
			dy: Int
	) {
		if (dy > 0 && !recyclerView!!.canScrollVertically(1)) {
			loadMore.invoke()
		}
	}
}
