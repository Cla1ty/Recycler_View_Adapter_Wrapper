/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Thursday, March 08, 2018 at 23:10                                                              *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.config

import com.dwiariyanto.recyclerview.R

object ErViAdapter
{
    private val configData = Config()

    fun config(config: Config.() -> Unit)
    {
        config.invoke(configData)
    }

    data class Config(
            var erViLoadMore: Int = R.layout.item_load_more,
            var erViNoItem: Int = R.layout.item_no_more,
            var erViNumberBeforeLoadMore: Int = 0
    )
}
