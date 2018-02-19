/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2017. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Wednesday, February 15, 2017                                                                   *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.decoration

import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * ____          ____
 * |    |        |    |
 * |____| <span> |____|
 *
 *
 * <span>        <span>
 * ____          ____
 * |    |        |    |
 * |____| <span> |____|
</span></span></span></span> */

class GridSpanContentDecoration(
		private val spanSize: Float = 0f,
		private val edge: Boolean = true
) : RecyclerView.ItemDecoration() {
	
	private var spanCount = 0
	
	override fun getItemOffsets(
			outRect: Rect,
			view: View,
			parent: RecyclerView,
			state: RecyclerView.State?
	) {
		if (spanCount == 0) {
			if (parent.layoutManager is GridLayoutManager) {
				spanCount = (parent.layoutManager as GridLayoutManager).spanCount
			}
			
			if (spanCount == 0) return
		}
		
		val lIndex = parent.getChildLayoutPosition(view)
		val lPosition = lIndex % spanCount
		
		outRect.left = when {
			edge -> (spanSize / spanCount * (spanCount - lPosition)).toInt()
			else -> (spanSize / spanCount * lPosition).toInt()
		}
		outRect.right = when {
			edge -> (spanSize / spanCount * (1 + lPosition)).toInt()
			else -> (spanSize / spanCount * (spanCount - 1 - lPosition)).toInt()
		}
		outRect.top = when {
			edge && lIndex < spanCount   -> spanSize.toInt()
			!edge && lIndex >= spanCount -> spanSize.toInt()
			else                         -> 0
		}
		outRect.bottom = when {
			edge -> spanSize.toInt()
			else -> 0
		}
	}
}
