package com.devcamp.devcamp_mobile.module.my_products

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

class MyProductsAdapter(val dataList: List<GarageSaleProductListItem>) :
    RecyclerView.Adapter<MyProductsAdapter.MyProductsViewHolder>() {

    class MyProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imItemImage: ImageView
        val tvItemName: TextView
        val tvPrice: TextView
        val tvStock: TextView

        init {
            imItemImage = itemView.findViewById(R.id.imItemImage)
            tvItemName = itemView.findViewById(R.id.tvItemName)
            tvPrice = itemView.findViewById(R.id.tvPrice)
            tvStock = itemView.findViewById(R.id.tvStock)
        }

        fun bind(productListItem: GarageSaleProductListItem) {
            tvItemName.text = productListItem.name
            tvPrice.text = productListItem.price.toString()
            tvStock.text = productListItem.stock.toString()
            Glide.with(itemView.context).load(productListItem.imageUrl).into(imItemImage)
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyProductsViewHolder, position: Int) = holder.bind(dataList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_my_products, parent, false)
        return MyProductsViewHolder(view)

    }


}