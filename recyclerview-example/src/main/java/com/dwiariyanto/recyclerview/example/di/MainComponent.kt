/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:10                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.di

import com.dwiariyanto.recyclerview.example.MainApplication
import com.dwiariyanto.recyclerview.example.di.module.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton @Component(
		modules = arrayOf(
				AndroidInjectionModule::class,
				ApplicationModule::class
		)
) interface MainComponent : AndroidInjector<MainApplication> {
	
	@Component.Builder abstract class Builder : AndroidInjector.Builder<MainApplication>()
	
}