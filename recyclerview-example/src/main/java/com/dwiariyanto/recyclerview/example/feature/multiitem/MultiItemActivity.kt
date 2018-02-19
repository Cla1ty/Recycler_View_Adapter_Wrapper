/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 22:43                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dwiariyanto.recyclerview.example.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.recyclerview.*
import javax.inject.Inject

class MultiItemActivity : AppCompatActivity(),
                          MultiItemView {
	
	@Inject lateinit var presenter: MultiItemPresenter
	@Inject lateinit var adapter: MultiItemVerticalAdapter
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		AndroidInjection.inject(this)
		setContentView(R.layout.recyclerview)
		
		adapter.recyclerView = recyclerView
		presenter.loadData()
	}
	
	override fun showData(dataList: List<Any>) {
		adapter.data = dataList
	}
	
	override fun showToast(message: String) {
		Toast.makeText(
				this,
				message,
				Toast.LENGTH_SHORT
		)
				.show()
	}
}
