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
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * ______________________
 * |______________________|
 *
 *
 * <span>
 * ______________________
 * |______________________|
 * </span>
 */

@Deprecated(
		"Use ItemDecoration",
		ReplaceWith(
				"ItemDecoration",
				"om.dwiariyanto.recyclerview.decoration"
		)
) class LinearSpanContentDecoration(
		private var spanSize: Float = 0f,
		private val edge: Boolean = true
) : RecyclerView.ItemDecoration() {
	
	private var orientation = -1
	
	override fun getItemOffsets(
			outRect: Rect,
			view: View,
			parent: RecyclerView,
			state: RecyclerView.State
	) {
		
		if (orientation == -1) {
			if (parent.layoutManager is LinearLayoutManager) {
				orientation = (parent.layoutManager as LinearLayoutManager).orientation
			}
			
			if (orientation == -1) return
		}
		val lIndex = parent.getChildLayoutPosition(view)
		
		val front = when {
			edge && lIndex == 0  -> spanSize.toInt()
			!edge && lIndex >= 1 -> spanSize.toInt()
			else                 -> 0
		}
		val side = when {
			edge -> spanSize.toInt()
			else -> 0
		}
		val rear = when {
			edge -> spanSize.toInt()
			else -> 0
		}
		
		when (orientation) {
			OrientationHelper.VERTICAL   -> {
				outRect.left = side
				outRect.right = side
				outRect.top = front
				outRect.bottom = rear
			}
			OrientationHelper.HORIZONTAL -> {
				outRect.left = front
				outRect.top = side
				outRect.right = rear
				outRect.bottom = side
			}
		}
	}
}