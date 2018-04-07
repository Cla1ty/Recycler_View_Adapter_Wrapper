/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 22:45                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem

import javax.inject.Inject

class MultiItemPresenter
@Inject constructor(
		private val activity: MultiItemActivity
) {
	
	private val view: MultiItemView = activity
	private var data: List<MultiItemVerticalModel>? = null
	
	fun loadData() {
		data = MultiItemVerticalModel.data
		view.showData(MultiItemVerticalModel.data)
	}

	fun reloadData(){
		val data = mutableListOf<MultiItemVerticalModel>()
		MultiItemVerticalModel.data.forEach {
			val newListData = mutableListOf<Any>()

			it.dataList.forEach {
				newListData.add(it)
			}

			val newData = MultiItemVerticalModel(it.type, newListData)
			data.add(newData)
		}

		view.showData(data)
	}
	
	fun clickMore() {
		view.showToast("Click More")
	}
	
	fun clickItem(position: String) {
		view.showToast("Click Item $position")
	}
	
}
