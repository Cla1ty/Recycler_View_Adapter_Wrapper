/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Saturday, February 24, 2018 at 22:55                                                           *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.decoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class ItemDecoration(
		private var spanSize: Int,
		private val extraEdgeSize: Int = 0
) : RecyclerView.ItemDecoration() {
	
	private var config = true
	
	override fun getItemOffsets(
			outRect: Rect,
			view: View,
			parent: RecyclerView,
			state: RecyclerView.State?
	) {
		if (config) {
			config = false
			
			spanSize /= 2
			
			parent.clipToPadding = false
			
			val padding = spanSize + extraEdgeSize
			parent.setPadding(
					padding,
					padding,
					padding,
					padding
			)
		}
		
		outRect.left = spanSize
		outRect.top = spanSize
		outRect.right = spanSize
		outRect.bottom = spanSize
	}
}
