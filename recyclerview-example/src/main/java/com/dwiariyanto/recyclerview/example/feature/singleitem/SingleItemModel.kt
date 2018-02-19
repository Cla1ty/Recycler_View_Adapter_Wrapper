/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:28                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.singleitem

data class SingleItemModel(
		val number: String
) {
	
	companion object {
		val data = listOf(
				SingleItemModel("1"),
				SingleItemModel("2"),
				SingleItemModel("3"),
				SingleItemModel("4"),
				SingleItemModel("5"),
				SingleItemModel("6"),
				SingleItemModel("7"),
				SingleItemModel("8")
		)
		
		val data2 = listOf(
				SingleItemModel("1"),
				SingleItemModel("3"),
				SingleItemModel("5"),
				SingleItemModel("6"),
				SingleItemModel("8")
		)
	}
}
