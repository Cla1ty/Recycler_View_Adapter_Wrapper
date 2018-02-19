/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 22:47                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem

data class MultiItemVerticalModel(
		val dataList: List<Any>
) {
	
	companion object {
		val data = listOf(
				MultiItemVerticalModel(
						listOf(
								MultiItemHorizontalModel("1"),
								MultiItemHorizontalModel("2"),
								MultiItemHorizontalModel("3"),
								MultiItemHorizontalMoreModel()
						)
				),
				MultiItemVerticalModel(
						listOf(
								MultiItemHorizontalModel("1"),
								MultiItemHorizontalModel("2"),
								MultiItemHorizontalModel("3"),
								MultiItemHorizontalMoreModel()
						)
				),
				MultiItemVerticalModel(
						listOf(
								MultiItemHorizontalModel("1"),
								MultiItemHorizontalModel("2"),
								MultiItemHorizontalModel("3"),
								MultiItemHorizontalMoreModel()
						)
				),
				MultiItemVerticalModel(
						listOf(
								MultiItemHorizontalModel("1"),
								MultiItemHorizontalModel("2"),
								MultiItemHorizontalModel("3"),
								MultiItemHorizontalMoreModel()
						)
				)
		)
	}
}
