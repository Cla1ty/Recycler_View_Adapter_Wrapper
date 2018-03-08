/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Thursday, March 08, 2018 at 22:03                                                              *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.empty

import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.recyclerview.example.R
import javax.inject.Inject

class EmptyItem
@Inject constructor() : BaseItemView<EmptyModel>(
        EmptyModel::class.java,
        R.layout.item_textview
)
{
    override fun onBind(holder: RecyclerViewHolder, data: EmptyModel)
    {
    }
}

