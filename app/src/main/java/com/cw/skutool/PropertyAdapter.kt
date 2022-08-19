package com.cw.skutool

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cw.skutool.model.SkuValue

class PropertyAdapter(
    private val data: List<SkuValue>,
    private val selectListener: (id: Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PropertyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.sku_item_sub, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val tvItem = holder.itemView.findViewById<TextView>(R.id.tv_item)
        val skuValue = data[position]
        tvItem.text = skuValue.value

        if (skuValue.disable) {
            tvItem.background = ContextCompat.getDrawable(
                holder.itemView.context,
                R.drawable.bg_sku_item_disable
            )
            tvItem.setTextColor(Color.parseColor("#999999"))
        } else {
            if (skuValue.selected) {
                tvItem.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.bg_sku_item_select
                )
                tvItem.setTextColor(Color.parseColor("#FF542A"))
            } else {
                tvItem.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.bg_sku_item_normal
                )
                tvItem.setTextColor(Color.parseColor("#333333"))
            }
        }

        tvItem.setOnClickListener {
            if (skuValue.disable) return@setOnClickListener
            skuValue.selected = !skuValue.selected
            if (skuValue.selected) {
                data.forEach {
                    if (it != skuValue) {
                        it.selected = false
                    }
                }
            }
            selectListener.invoke(skuValue.id)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun refresh() {
        notifyDataSetChanged()
    }

    inner class PropertyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}