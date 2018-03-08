/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2018. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Thursday, March 08, 2018 at 21:59                                                              *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.example.feature.empty

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dwiariyanto.recyclerview.example.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.recyclerview.*
import javax.inject.Inject

class EmptyActivity : AppCompatActivity()
{
    @Inject lateinit var adapter: EmptyAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
        AndroidInjection.inject(this)

        recyclerView.adapter = adapter
        adapter.data = emptyList()
    }
}
