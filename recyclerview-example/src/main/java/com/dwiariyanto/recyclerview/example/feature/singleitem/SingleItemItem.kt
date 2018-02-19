/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:39                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.singleitem

import android.widget.TextView
import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.recyclerview.example.R
import javax.inject.Inject

class SingleItemItem
@Inject constructor(
		private val presenter: SingleItemPresenter
) : BaseItemView<SingleItemModel>(
		SingleItemModel::class.java,
		R.layout.item_textview
) {
	
	override fun onCreate(holder: RecyclerViewHolder) {}
	
	override fun onBind(
			holder: RecyclerViewHolder,
			data: SingleItemModel
	) {
		(holder.itemView as TextView).apply {
			text = data.number
			setOnClickListener { presenter.itemClick(data.number) }
		}
	}
}
