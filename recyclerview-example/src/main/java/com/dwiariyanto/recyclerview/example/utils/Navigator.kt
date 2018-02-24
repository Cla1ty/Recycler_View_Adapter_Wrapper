/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 22:05                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.utils

import android.content.Intent
import com.dwiariyanto.recyclerview.example.feature.home.HomeActivity
import javax.inject.Inject

class Navigator
@Inject constructor(
		private val context: HomeActivity
) {
	
	fun goto(
			clazz: Class<*>
	) {
		Intent(
				context,
				clazz
		).also {
			context.startActivity(it)
		}
	}
}
