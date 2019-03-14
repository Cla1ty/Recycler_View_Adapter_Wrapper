/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2019. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Saturday, January 12, 2019 at 10:00                                                            *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.loadmorewithoutnomore

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.dwiariyanto.log.info
import com.dwiariyanto.recyclerview.example.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.recyclerview.*
import javax.inject.Inject

class LoadMoreWithoutNoMoreActivity : AppCompatActivity() {
	@Inject lateinit var adapterMoreWithoutNo: LoadMoreWithoutNoMoreAdapter
	
	private val handler = Handler()
	private var runnable: Runnable? = null
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.recyclerview)
		AndroidInjection.inject(this)
		
		recyclerView.adapter = adapterMoreWithoutNo
		
		val data = getInitiationData()
		adapterMoreWithoutNo.data = data
		
		adapterMoreWithoutNo.onLoadMore {
			info("LOAD MORE")
			
			removeCallback()
			loadMore(it)
		}
	}
	
	private fun loadMore(lastSizeData: Int) {
		runnable = Runnable {
			val updateData = getUpdateData(lastSizeData - 5)
			adapterMoreWithoutNo.updateData(updateData) { lastData, updateData ->
				(lastData as LoadMoreWithoutNoMoreModel).number == (updateData as LoadMoreWithoutNoMoreModel).number
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
	
	private fun getInitiationData(): MutableList<LoadMoreWithoutNoMoreModel> {
		val data = mutableListOf<LoadMoreWithoutNoMoreModel>()
		(0 until 10).forEach { data.add(LoadMoreWithoutNoMoreModel(it.toString())) }
		return data
	}
	
	private fun getUpdateData(lastSizeData: Int): MutableList<LoadMoreWithoutNoMoreModel> {
		val updateData = mutableListOf<LoadMoreWithoutNoMoreModel>()
		if (lastSizeData < 30) {
			(lastSizeData until lastSizeData + 10).forEach {
				updateData.add(LoadMoreWithoutNoMoreModel(it.toString()))
			}
		}
		return updateData
	}
}
