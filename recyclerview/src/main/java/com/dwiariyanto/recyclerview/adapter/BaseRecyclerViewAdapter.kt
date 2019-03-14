/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2017. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Create On:                                                                                     *
 * Wednesday, June 14, 2017                                                                       *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.recyclerview.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dwiariyanto.recyclerview.config.ErViConfig
import com.dwiariyanto.recyclerview.itemview.LoadMoreData
import com.dwiariyanto.recyclerview.itemview.LoadMoreItem
import com.dwiariyanto.recyclerview.itemview.NoMoreData
import com.dwiariyanto.recyclerview.itemview.NoMoreItem
import java.util.*

abstract class BaseRecyclerViewAdapter(
        vararg items: BaseItemView<*>
) : RecyclerView.Adapter<RecyclerViewHolder>()
{
    private var numberItemBeforeLoadMore = -1
    private var onLoadMore: ((lastSizeData: Int) -> Unit)? = null
    private var isLoadMoreExecute = false

    private val isLoadMoreEnable
        get() = numberItemBeforeLoadMore >= 0

    private val itemLayouts = ArrayList<BaseItemView<*>>()
    private var dataName = mutableListOf<String>()

    var data: List<Any>? = null
        set(value)
        {
            val isNoMoreData = value == null || value.isEmpty() || value.last()::class.java.name != NoMoreData::class.java.name
            isLoadMoreExecute = !isNoMoreData

            val newValue = when
            {
                isLoadMoreEnable && value != null && value.isNotEmpty() && isNoMoreData ->
                {
                    val newValue = mutableListOf<Any>()
                    newValue.addAll(value)
                    newValue.add(LoadMoreData())
                    newValue
                }
                else ->
                {
                    value
                }
            }

            val result = DiffUtil.calculateDiff(object : DiffUtil.Callback()
            {
                override fun getOldListSize(): Int = field?.size ?: 0
                override fun getNewListSize(): Int = newValue?.size ?: 0

                override fun areItemsTheSame(
                        oldItemPosition: Int,
                        newItemPosition: Int
                ): Boolean = field != null && newValue != null && field!![oldItemPosition] == newValue[newItemPosition]

                override fun areContentsTheSame(
                        oldItemPosition: Int,
                        newItemPosition: Int
                ): Boolean = field != null && newValue != null && field!![oldItemPosition] == newValue[newItemPosition]
            })

            dataName.clear()
            newValue?.forEach { dataName.add(it::class.java.name) }

            field = newValue
            result.dispatchUpdatesTo(this)
        }

    init
    {
        itemLayouts.addAll(items)
    }

    abstract fun build(recyclerView: RecyclerView)

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView)
    {
        build(recyclerView)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RecyclerViewHolder
    {
        val itemLayout = itemLayouts[viewType]
        val view = LayoutInflater.from(parent.context)
                .inflate(itemLayout.layoutId, parent, false)
        val holder = RecyclerViewHolder(view)

        itemLayout.onCreate(holder)

        return holder
    }

    override fun onBindViewHolder(
            holder: RecyclerViewHolder,
            position: Int
    )
    {
        val viewType = holder.itemViewType
        val itemLayout = itemLayouts[viewType]
        itemLayout.bind.invoke(
                holder,
                data!![position]
        )

        if (isLoadMoreEnable && position >= itemCount - numberItemBeforeLoadMore - 1)
        {
            performLoadMore()
        }
    }

    override fun onViewRecycled(holder: RecyclerViewHolder)
    {
        val itemLayout = itemLayouts[holder.itemViewType]
        itemLayout.onRecycler(holder)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun getItemViewType(position: Int): Int
    {
        val name = dataName[position]
        return (0 until itemLayouts.size).firstOrNull { itemLayouts[it].id == name }
               ?: throw IllegalArgumentException("Item View \"$name\" Not Found")
    }

    fun enableLoadMore(
            numberItemBeforeLoadMore: Int = ErViConfig.configData.erViNumberBeforeLoadMore,
            loadMoreLayoutId: Int = ErViConfig.configData.erViLoadMore,
            noMoreLayoutId: Int = ErViConfig.configData.erViNoItem
    )
    {
        itemLayouts
                .filter { it.id == LoadMoreData::class.java.name || it.id == NoMoreData::class.java.name }
                .forEach { itemLayouts.remove(it) }

        itemLayouts.add(LoadMoreItem(loadMoreLayoutId))
        itemLayouts.add(NoMoreItem(noMoreLayoutId))

        this.numberItemBeforeLoadMore = numberItemBeforeLoadMore
    }

    private fun performLoadMore()
    {
        if (isLoadMoreExecute) return
        isLoadMoreExecute = true

        onLoadMore?.invoke(itemCount - 1)
    }

    fun onLoadMore(onLoadMore: (lastSizeData: Int) -> Unit)
    {
        this.onLoadMore = onLoadMore
    }

    fun updateData(
            updateData: List<Any>,
            duplicatePrediction: ((lastData: Any, updateData: Any) -> Boolean)? = null
    )
    {
        val newData = mutableListOf<Any>()
        data?.filter { it !is LoadMoreData }
                ?.forEach { newData.add(it) }

        if (updateData.isNotEmpty())
        {
            var startAdd = 0
            if (duplicatePrediction != null)
            {
                val lastData = newData.last()
                updateData.forEachIndexed { index, data ->
                    val isDuplicate = duplicatePrediction.invoke(lastData, data)
                    if (isDuplicate)
                    {
                        startAdd = index + 1
                        return@forEachIndexed
                    }
                }
            }
            (startAdd until updateData.size).forEach {
                newData.add(updateData[it])
            }
        }
        else
        {
            newData.add(NoMoreData())
        }

        data = newData
    }
}

