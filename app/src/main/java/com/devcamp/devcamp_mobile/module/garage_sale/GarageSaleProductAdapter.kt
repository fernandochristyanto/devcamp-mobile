package com.devcamp.devcamp_mobile.module.garage_sale

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.common.GarageSaleProductListItem

class GarageSaleProductAdapter(val dataList: List<GarageSaleProductListItem>):RecyclerView.Adapter<GarageSaleProductAdapter.GarageSaleProductViewHolder>() {

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

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: GarageSaleProductViewHolder, position: Int) {
        holder.tvItemName.text = dataList[position].name
        holder.tvPrice.text = dataList[position].price.toString()
        holder.tvShopName.text = dataList[position].shopName
        Glide.with(holder.itemView).load(dataList[position].imageUrl).into(holder.imItemImage)

        if (dataList[position].charity) {
            holder.tvCharity.text = "dana yang didapat akan di donasikan"
        } else {
            holder.tvCharity.text = ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GarageSaleProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_garage_sale, parent, false)
        return GarageSaleProductViewHolder(view)

    }





}