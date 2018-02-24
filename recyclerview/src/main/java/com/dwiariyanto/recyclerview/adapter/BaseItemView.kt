/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2017. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Wednesday, June 14, 2017                                                                       *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.adapter

abstract class BaseItemView<in DATA : Any>(
		clazz: Class<DATA>,
		internal val layoutId: Int
) {
	
	internal val id: String = clazz.name
	internal var bind: ((holder: RecyclerViewHolder, data: Any) -> Unit)? = null
	
	init {
		bind = { holder, data ->
			onBind(
					holder,
					data as DATA
			)
		}
	}
	
	open fun onCreate(holder: RecyclerViewHolder) {}
	
	abstract fun onBind(
			holder: RecyclerViewHolder,
			data: DATA
	)
	
	open fun onRecycler(holder: RecyclerViewHolder) {}
}