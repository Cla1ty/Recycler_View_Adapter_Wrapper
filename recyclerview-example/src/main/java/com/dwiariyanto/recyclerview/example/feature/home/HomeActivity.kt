/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:26                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dwiariyanto.recyclerview.example.R
import com.dwiariyanto.recyclerview.example.feature.empty.EmptyActivity
import com.dwiariyanto.recyclerview.example.feature.loadmore.LoadMoreActivity
import com.dwiariyanto.recyclerview.example.feature.loadmorewithoutnomore.LoadMoreWithoutNoMoreActivity
import com.dwiariyanto.recyclerview.example.feature.multiitem.MultiItemActivity
import com.dwiariyanto.recyclerview.example.feature.multiitem2.MultiItem2Activity
import com.dwiariyanto.recyclerview.example.feature.singleitem.SingleItemActivity
import com.dwiariyanto.recyclerview.example.utils.Navigator
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {
	@Inject lateinit var navigator: Navigator
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		AndroidInjection.inject(this)
		setContentView(R.layout.activity_main)

		setupButton()
	}
	
	private fun setupButton() {
		btnSingleItem.setOnClickListener { navigator.goTo(SingleItemActivity::class.java) }
		btnMultiItem.setOnClickListener { navigator.goTo(MultiItemActivity::class.java) }
		btnLoadMore.setOnClickListener { navigator.goTo(LoadMoreActivity::class.java) }
		btnLoadMoreWithoutNoMore.setOnClickListener { navigator.goTo(LoadMoreWithoutNoMoreActivity::class.java) }
		btnEmpty.setOnClickListener { navigator.goTo(EmptyActivity::class.java) }
		btnMultiItem2.setOnClickListener { navigator.goTo(MultiItem2Activity::class.java) }
	}
}
