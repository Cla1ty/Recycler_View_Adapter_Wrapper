/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, March 04, 2018 at 21:05                                                                *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.itemview

import com.dwiariyanto.recyclerview.adapter.BaseItemView

internal class LoadMoreItem(
        layoutId: Int
) : BaseItemView<LoadMoreData>(
        LoadMoreData::class.java,
        layoutId
)

internal class LoadMoreData