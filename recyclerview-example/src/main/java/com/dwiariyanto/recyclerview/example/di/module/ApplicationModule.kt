/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:11                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.di.module

import android.content.Context
import com.dwiariyanto.recyclerview.example.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
		includes = arrayOf(
				ActivityModule::class
		)
) class ApplicationModule {
	
	@Provides @Singleton fun provideApplicationContext(application: MainApplication): Context =
			application.applicationContext
}
