/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Thursday, March 08, 2018 at 23:40                                                              *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.extension

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.dwiariyanto.recyclerview.decoration.ItemDecoration

inline fun RecyclerView.erViDecor(decor: ItemDecoration.() -> Unit)
{
    val itemDecoration = ItemDecoration()
    addItemDecoration(itemDecoration)
    decor.invoke(itemDecoration)
}

inline fun RecyclerView.erViManager(manager: ManagerData.() -> Unit)
{
    val managerData = ManagerData()
    manager.invoke(managerData)

    layoutManager = when
    {
        managerData.erViCount == 1 ->
            LinearLayoutManager(context,
                    managerData.erViOrientation,
                    managerData.erViReverse)
        else ->
            GridLayoutManager(context,
                    managerData.erViCount,
                    managerData.erViOrientation,
                    managerData.erViReverse)
    }
}

data class ManagerData(
        var erViCount: Int = 1,
        var erViOrientation: Int = LinearLayout.VERTICAL,
        var erViReverse: Boolean = false
)