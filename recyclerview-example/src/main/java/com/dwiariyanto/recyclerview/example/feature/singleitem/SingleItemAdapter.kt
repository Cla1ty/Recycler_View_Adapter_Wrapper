/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Sunday, February 18, 2018 at 21:48                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.singleitem

import android.support.v7.widget.RecyclerView
import com.dwiariyanto.recyclerview.adapter.BaseRecyclerViewAdapter
import com.dwiariyanto.recyclerview.example.utils.sp
import com.dwiariyanto.recyclerview.extension.erViDecor
import com.dwiariyanto.recyclerview.extension.erViManager
import javax.inject.Inject

class SingleItemAdapter
@Inject constructor(
        singleItemItem: SingleItemItem
) : BaseRecyclerViewAdapter(
        singleItemItem
)
{
    override fun build(recyclerView: RecyclerView)
    {
        recyclerView.apply {
            erViDecor { erViSpanSize = 16.sp }
            erViManager { erViCount = 2 }
        }
    }
}
