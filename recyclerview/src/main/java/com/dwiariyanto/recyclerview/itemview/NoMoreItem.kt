/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Monday, March 05, 2018 at 22:14                                                                *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.itemview

import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder

internal class NoMoreItem(
		layoutId: Int
) : BaseItemView<NoMoreData>(
		NoMoreData::class.java,
		layoutId
) {
	
	override fun onBind(
			holder: RecyclerViewHolder,
			data: NoMoreData
	) {
	}
}

internal class NoMoreData
