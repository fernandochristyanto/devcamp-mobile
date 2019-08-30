package com.devcamp.devcamp_mobile.module.my_products

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.common.GarageSaleProduct

class MyProductsAdapter(val dataList: List<GarageSaleProduct>):RecyclerView.Adapter<MyProductsAdapter.MyProductsViewHolder>() {

    class MyProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imItemImage: ImageView
        val tvItemName: TextView
        val tvPrice: TextView

        init {
            imItemImage = itemView.findViewById(R.id.imItemImage)
            tvItemName = itemView.findViewById(R.id.tvItemName)
            tvPrice = itemView.findViewById(R.id.tvPrice)
        }
    }

    override fun getItemCount(): Int {

        if (null != dataList) {
            return dataList!!.size
        } else {
            return 0
        }
    }

    override fun onBindViewHolder(holder: MyProductsViewHolder, position: Int) {
        // TODO: Item Image
        // TODO: Shop Name
        holder.tvItemName.setText(dataList?.get(position)?.name)
        holder.tvPrice.setText(dataList?.get(position)?.price.toString())

//        if (dataList?.get(position)!!.charity) {
//            holder.tvCharity.setText("dana yang didapat akan di donasikan")
//        } else {
//            holder.tvCharity.setText("")
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_my_products, parent, false)
        return MyProductsViewHolder(view)

    }





}