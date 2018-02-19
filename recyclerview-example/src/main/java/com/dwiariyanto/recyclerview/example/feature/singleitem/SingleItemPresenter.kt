/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:27                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.singleitem

import android.os.Handler
import javax.inject.Inject

class SingleItemPresenter
@Inject constructor(
		activity: SingleItemActivity
) {
	
	private val view: SingleItemView = activity
	
	private var run: Runnable? = null
	private val handler: Handler by lazy { Handler() }
	
	fun loadData() {
		add()
	}
	
	fun removeCallback() {
		handler.removeCallbacks(run)
	}
	
	fun itemClick(number: String) {
		view.onItemClick(number)
	}
	
	private fun remove() {
		view.showData(SingleItemModel.data2)
		
		run = Runnable {
			add()
		}
		
		postDelay()
	}
	
	private fun add() {
		view.showData(SingleItemModel.data)
		
		run = Runnable {
			remove()
		}
		
		postDelay()
	}
	
	private fun postDelay() {
		handler.postDelayed(
				run,
				3000
		)
	}
}
