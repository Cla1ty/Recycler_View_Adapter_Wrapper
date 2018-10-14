/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:25                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.singleitem

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dwiariyanto.recyclerview.example.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.recyclerview.*
import javax.inject.Inject

class SingleItemActivity : AppCompatActivity(),
                           SingleItemView {
	
	@Inject lateinit var presenter: SingleItemPresenter
	@Inject lateinit var adapter: SingleItemAdapter
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		AndroidInjection.inject(this)
		setContentView(R.layout.recyclerview)
		
		recyclerView.adapter = adapter
	}
	
	override fun onStart() {
		super.onStart()
		presenter.loadData()
	}
	
	override fun onPause() {
		super.onPause()
		presenter.removeCallback()
	}
	
	override fun showData(dataList: List<SingleItemModel>) {
		adapter.data = dataList
		recyclerView.requestLayout()
	}
	
	override fun onItemClick(number: String) {
		Toast.makeText(
				this,
				"Click $number",
				Toast.LENGTH_SHORT
		)
				.show()
	}
}
