/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, March 04, 2018 at 21:50                                                                *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.loadmore

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.dwiariyanto.log.info
import com.dwiariyanto.recyclerview.example.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.recyclerview.*
import javax.inject.Inject

class LoadMoreActivity : AppCompatActivity() {
	@Inject lateinit var adapter: LoadMoreAdapter
	
	private val handler = Handler()
	private var runnable: Runnable? = null
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.recyclerview)
		AndroidInjection.inject(this)
		
		recyclerView.adapter = adapter
		
		val data = getInitiationData()
		adapter.data = data
		
		adapter.onLoadMore {
			info("LOAD MORE")
			
			removeCallback()
			loadMore(it)
		}
	}
	
	private fun loadMore(lastSizeData: Int) {
		runnable = Runnable {
			val updateData = getUpdateData(lastSizeData - 5)
			adapter.updateData(updateData) { lastData, updateData ->
				(lastData as LoadMoreModel).number == (updateData as LoadMoreModel).number
			}
		}
		handler.postDelayed(
				runnable,
				2000
		)
	}
	
	override fun onStop() {
		super.onStop()
		removeCallback()
	}
	
	private fun removeCallback() {
		runnable?.apply { handler.removeCallbacks(this) }
	}
	
	private fun getInitiationData(): MutableList<LoadMoreModel> {
		val data = mutableListOf<LoadMoreModel>()
		(0 until 20).forEach { data.add(LoadMoreModel(it.toString())) }
		return data
	}
	
	private fun getUpdateData(lastSizeData: Int): MutableList<LoadMoreModel> {
		val updateData = mutableListOf<LoadMoreModel>()
		if (lastSizeData < 50) {
			(lastSizeData until lastSizeData + 10).forEach {
				updateData.add(LoadMoreModel(it.toString()))
			}
		}
		return updateData
	}
}
