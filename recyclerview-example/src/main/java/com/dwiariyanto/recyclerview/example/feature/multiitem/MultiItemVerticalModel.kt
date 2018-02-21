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
		val type: String,
		val dataList: List<Any>
) {
	
	companion object {
		val data = listOf(
				MultiItemVerticalModel(
						"1",
						listOf(
								MultiItemHorizontalModel("1"),
								MultiItemHorizontalModel("2"),
								MultiItemHorizontalModel("3"),
								MultiItemHorizontalMoreModel()
						)
				),
				MultiItemVerticalModel(
						"2",
						listOf(
								MultiItemHorizontalModel("4"),
								MultiItemHorizontalModel("5"),
								MultiItemHorizontalModel("6"),
								MultiItemHorizontalMoreModel()
						)
				),
				MultiItemVerticalModel(
						"3",
						listOf(
								MultiItemHorizontalModel("7"),
								MultiItemHorizontalModel("8"),
								MultiItemHorizontalModel("9"),
								MultiItemHorizontalMoreModel()
						)
				),
				MultiItemVerticalModel(
						"4",
						listOf(
								MultiItemHorizontalModel("10"),
								MultiItemHorizontalModel("11"),
								MultiItemHorizontalModel("12"),
								MultiItemHorizontalMoreModel()
						)
				)
		)
	}
}
