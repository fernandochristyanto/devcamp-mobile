package com.devcamp.devcamp_mobile.module.garage_sale

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.common.GarageSaleProduct

class GarageSaleProductAdapter(val dataList: List<GarageSaleProduct>):RecyclerView.Adapter<GarageSaleProductAdapter.GarageSaleProductViewHolder>() {

    class GarageSaleProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imItemImage: ImageView
        val tvShopName: TextView
        val tvItemName: TextView
        val tvPrice: TextView
        val tvCharity: TextView

        init {
            imItemImage = itemView.findViewById(R.id.imItemImage)
            tvShopName = itemView.findViewById(R.id.tvShopName)
            tvItemName = itemView.findViewById(R.id.tvItemName)
            tvPrice = itemView.findViewById(R.id.tvPrice)
            tvCharity = itemView.findViewById(R.id.tvCharity)
        }
    }

    override fun getItemCount(): Int {

        if (null != dataList) {
            return dataList!!.size
        } else {
            return 0
        }
    }

    override fun onBindViewHolder(holder: GarageSaleProductViewHolder, position: Int) {
        // TODO: Item Image
        // TODO: Shop Name
        holder.tvItemName.setText(dataList?.get(position)?.name)
        holder.tvPrice.setText(dataList?.get(position)?.price.toString())

        if (dataList?.get(position)!!.charity) {
            holder.tvCharity.setText("dana yang didapat akan di donasikan")
        } else {
            holder.tvCharity.setText("")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GarageSaleProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_garage_sale, parent, false)
        return GarageSaleProductViewHolder(view)

    }





}