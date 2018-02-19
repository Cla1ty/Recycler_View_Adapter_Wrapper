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
		activity: MultiItemActivity
) {
	
	private val view: MultiItemView = activity
	
	fun loadData() {
		view.showData(MultiItemVerticalModel.data)
	}
	
	fun clickMore() {
		view.showToast("Click More")
	}
	
	fun clickItem(position: String) {
		view.showToast("Click Item $position")
	}
	
}
