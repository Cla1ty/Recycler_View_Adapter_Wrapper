/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 22:55                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem

import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.recyclerview.example.R
import kotlinx.android.synthetic.main.item_vertical.view.*
import javax.inject.Inject

class MultiItemVerticalItem
@Inject constructor(
		private val horizontalItem: MultiItemHorizontalItem,
		private val horizontalMoreItem: MultiItemHorizontalMoreItem
) : BaseItemView<MultiItemVerticalModel>(
		MultiItemVerticalModel::class.java,
		R.layout.item_vertical
) {
	
	override fun onCreate(holder: RecyclerViewHolder) {}
	
	override fun onBind(
			holder: RecyclerViewHolder,
			data: MultiItemVerticalModel
	) {
		val adapter = MultiItemHorizontalAdapter(
				horizontalItem,
				horizontalMoreItem
		)
		
		data.dataList.filter { it is MultiItemHorizontalMoreModel }
				.forEach { (it as MultiItemHorizontalMoreModel).type = data.type }
		
		holder.itemView.recyclerView.adapter = adapter
		adapter.data = data.dataList
	}
}

