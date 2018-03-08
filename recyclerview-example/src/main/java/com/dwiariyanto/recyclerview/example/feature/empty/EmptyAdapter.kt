/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Thursday, March 08, 2018 at 22:06                                                              *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.empty

import android.support.v7.widget.RecyclerView
import com.dwiariyanto.recyclerview.adapter.BaseRecyclerViewAdapter
import com.dwiariyanto.recyclerview.extension.erViManager
import javax.inject.Inject

class EmptyAdapter
@Inject internal constructor(
        item: EmptyItem
) : BaseRecyclerViewAdapter(
        item
)
{
    override fun build(recyclerView: RecyclerView)
    {
        recyclerView.erViManager {  }
    }
}
