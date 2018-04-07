/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Wednesday, March 28, 2018 at 22:14                                                             *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.multiitem2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dwiariyanto.recyclerview.example.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.recyclerview.*
import javax.inject.Inject

class MultiItem2Activity : AppCompatActivity()
{
    private val dataDummy = listOf(
            MultiItem2HeaderData(),
            MultiItem2ContentData(),
            MultiItem2ContentData(),
            MultiItem2ContentData(),
            MultiItem2ContentData(),
            MultiItem2ContentData(),
            MultiItem2ContentData(),
            MultiItem2ContentData(),
            MultiItem2ContentData(),
            MultiItem2ContentData(),
            MultiItem2ContentData()
    )

    @Inject lateinit var adapter: MultiItem2Adapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview)
        AndroidInjection.inject(this)

        recyclerView.adapter = adapter
        adapter.data = dataDummy
    }
}