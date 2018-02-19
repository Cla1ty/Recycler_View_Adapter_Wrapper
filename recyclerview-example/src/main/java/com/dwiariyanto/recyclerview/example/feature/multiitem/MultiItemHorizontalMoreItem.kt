/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 22:49                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem

import android.widget.TextView
import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.recyclerview.example.R
import javax.inject.Inject

class MultiItemHorizontalMoreItem
@Inject constructor(
		private val presenter: MultiItemPresenter
) : BaseItemView<MultiItemHorizontalMoreModel>(
		MultiItemHorizontalMoreModel::class.java,
		R.layout.item_horizontal
) {
	
	override fun onCreate(holder: RecyclerViewHolder) {}
	
	override fun onBind(
			holder: RecyclerViewHolder,
			data: MultiItemHorizontalMoreModel
	) {
		(holder.itemView as TextView).apply {
			text = "More"
			setOnClickListener {
				presenter.clickMore()
			}
		}
	}
}
