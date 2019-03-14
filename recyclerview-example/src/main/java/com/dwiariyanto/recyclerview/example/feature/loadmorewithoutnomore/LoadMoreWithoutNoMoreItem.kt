/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2019. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, March 04, 2018 at 22:10                                                                *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.loadmorewithoutnomore

import android.widget.TextView
import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.recyclerview.example.R
import javax.inject.Inject

class LoadMoreWithoutNoMoreItem
@Inject constructor() : BaseItemView<LoadMoreWithoutNoMoreModel>(
		LoadMoreWithoutNoMoreModel::class.java,
		R.layout.item_textview
) {
	
	override fun onBind(
			holder: RecyclerViewHolder,
			data: LoadMoreWithoutNoMoreModel
	) {
		(holder.itemView as TextView).text = data.number
	}
}
