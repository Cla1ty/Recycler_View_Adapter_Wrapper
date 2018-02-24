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
import java.util.*

abstract class BaseRecyclerViewAdapter(
		vararg items: BaseItemView<*>
) : RecyclerView.Adapter<RecyclerViewHolder>() {
	
	private val itemLayouts = ArrayList<BaseItemView<*>>()
	
	private var oldDataName = mutableListOf<String>()
	var data: List<Any>? = null
		set(value) {
			val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
				override fun getOldListSize(): Int = field?.size
				                                     ?: 0
				
				override fun getNewListSize(): Int = value?.size
				                                     ?: 0
				
				override fun areItemsTheSame(
						oldItemPosition: Int,
						newItemPosition: Int
				): Boolean =
						field != null && value != null && field!![oldItemPosition] == value[newItemPosition]
				
				override fun areContentsTheSame(
						oldItemPosition: Int,
						newItemPosition: Int
				): Boolean =
						field != null && value != null && field!![oldItemPosition] == value[newItemPosition]
			})
			
			if (field != null) {
				oldDataName.clear()
				field!!.forEach { oldDataName.add(it::class.java.name) }
			}
			
			field = value
			result.dispatchUpdatesTo(this)
		}
	
	@Deprecated(
			"Use recyclerView.adapter = adapter",
			ReplaceWith("recyclerView.adapter = adapter")
	) var recyclerView: RecyclerView? = null
		set(value) {
			field = value
			field?.apply {
				adapter = this@BaseRecyclerViewAdapter
			}
		}
	
	init {
		itemLayouts.addAll(items)
	}
	
	abstract fun build(recyclerView: RecyclerView)
	
	override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
		build(recyclerView!!)
	}
	
	override fun onCreateViewHolder(
			parent: ViewGroup?,
			viewType: Int
	): RecyclerViewHolder {
		val itemLayout = itemLayouts[viewType]
		val view = LayoutInflater.from(parent!!.context)
				.inflate(
						itemLayout.layoutId,
						parent,
						false
				)
		val holder = RecyclerViewHolder(view)
		itemLayout.onCreate(holder)
		return holder
	}
	
	override fun onBindViewHolder(
			holder: RecyclerViewHolder?,
			position: Int
	) {
		val viewType = holder!!.itemViewType
		val itemLayout = itemLayouts[viewType]
		itemLayout.bind?.invoke(
				holder,
				data!![position]
		)
	}
	
	override fun onViewRecycled(holder: RecyclerViewHolder) {
		val itemLayout = itemLayouts[holder.itemViewType]
		itemLayout.onRecycler(holder)
	}
	
	override fun getItemCount(): Int = data?.size
	                                   ?: 0
	
	override fun getItemViewType(position: Int): Int {
		val name = data!![position]::class.java.name
		return (0 until itemLayouts.size).firstOrNull { itemLayouts[it].id == name }
		       ?: throw IllegalArgumentException("Item View \"$name\" Not Found")
	}
	
}

