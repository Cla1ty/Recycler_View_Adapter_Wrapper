/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:17                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.di.module

import com.dwiariyanto.recyclerview.example.di.module.base.EmptyModule
import com.dwiariyanto.recyclerview.example.feature.empty.EmptyActivity
import com.dwiariyanto.recyclerview.example.feature.home.HomeActivity
import com.dwiariyanto.recyclerview.example.feature.loadmorewithoutnomore.LoadMoreWithoutNoMoreActivity
import com.dwiariyanto.recyclerview.example.feature.multiitem.MultiItemActivity
import com.dwiariyanto.recyclerview.example.feature.multiitem2.MultiItem2Activity
import com.dwiariyanto.recyclerview.example.feature.singleitem.SingleItemActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module abstract class ActivityModule {
	@ContributesAndroidInjector(modules = [(EmptyModule::class)]) abstract fun provideHomeActivity(): HomeActivity
	@ContributesAndroidInjector(modules = [(EmptyModule::class)]) abstract fun provideSingleItemActivity(): SingleItemActivity
	@ContributesAndroidInjector(modules = [(EmptyModule::class)]) abstract fun provideMultiItemActivity(): MultiItemActivity
	@ContributesAndroidInjector(modules = [(EmptyModule::class)]) abstract fun provideLoadMoreActivity(): LoadMoreWithoutNoMoreActivity
	@ContributesAndroidInjector(modules = [(EmptyModule::class)]) abstract fun provideEmptyActivity(): EmptyActivity
	@ContributesAndroidInjector(modules = [(EmptyModule::class)]) abstract fun provideMultiItem2Activity(): MultiItem2Activity
}
