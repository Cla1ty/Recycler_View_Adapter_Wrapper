/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:08                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example

import com.dwiariyanto.recyclerview.example.di.DaggerMainComponent
import com.dwiariyanto.recyclerview.example.utils.MathHelper
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApplication : DaggerApplication() {
	override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
			DaggerMainComponent.builder().create(this).apply {
				inject(this@MainApplication)
			}
	
	override fun onCreate() {
		super.onCreate()
		MathHelper.install(this)
	}
}
