/**************************************************************************************************
 * *
 * Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 * Copyright © 2018. All rights reserved.                             *
 * *
 * *
 * Create On:                                                                                     *
 * Sunday, March 04, 2018 at 21:52                                                                *
 * *
 */

package com.dwiariyanto.recyclerview.example.feature.loadmore

import android.widget.TextView
import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.recyclerview.example.R
import com.dwiariyanto.recyclerview.example.feature.loadmorewithoutnomore.LoadMoreWithoutNoMoreModel
import javax.inject.Inject

class LoadMoreItem
@Inject constructor() : BaseItemView<LoadMoreModel>(
		LoadMoreModel::class.java,
		R.layout.item_textview
) {
	
	override fun onBind(
			holder: RecyclerViewHolder,
			data: LoadMoreModel
	) {
		(holder.itemView as TextView).text = data.number
	}
}
