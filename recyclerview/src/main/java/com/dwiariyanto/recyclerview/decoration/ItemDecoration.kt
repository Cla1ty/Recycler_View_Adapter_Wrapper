/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Saturday, February 24, 2018 at 22:55                                                           *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.decoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class ItemDecoration(
        var erViSpanSize: Int = 0,
        var erViExtraLeft: Int = 0,
        var erViExtraTop: Int = 0,
        var erViExtraRight: Int = 0,
        var erViExtraBottom: Int = 0,
        var erViExtraEdgeSize: Int = 0
) : RecyclerView.ItemDecoration()
{
    private var config = true

    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State?
    )
    {
        if (config)
        {
            config = false

            erViSpanSize /= 2

            parent.clipToPadding = false

            val padding = erViSpanSize + erViExtraEdgeSize
            parent.setPadding(
                    padding,
                    padding,
                    padding,
                    padding
            )
        }

        outRect.left = erViSpanSize + erViExtraLeft
        outRect.top = erViSpanSize + erViExtraTop
        outRect.right = erViSpanSize + erViExtraRight
        outRect.bottom = erViSpanSize + erViExtraBottom
    }
}