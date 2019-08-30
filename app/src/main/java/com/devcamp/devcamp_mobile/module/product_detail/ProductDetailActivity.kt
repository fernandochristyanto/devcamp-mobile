package com.devcamp.devcamp_mobile.module.product_detail

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.devcamp.devcamp_mobile.R
import org.w3c.dom.Text

class ProductDetailActivity : AppCompatActivity() {
    lateinit var viewModel: ProductDetailViewModel

    lateinit var tvName: TextView
    lateinit var tvPrice: TextView
    lateinit var tvDescription: TextView
    lateinit var ivPoster: ImageView
    lateinit var rlSignDonationProduct: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail)

        tvName = findViewById(R.id.tvNamaItem)
        tvPrice = findViewById(R.id.tvPrice)
        tvDescription = findViewById(R.id.tvDescription)
        ivPoster = findViewById(R.id.ivPoster)
        rlSignDonationProduct = findViewById(R.id.rlSignDonationProduct)
        viewModel = ViewModelProviders.of(this).get(ProductDetailViewModel::class.java)
        viewModel.getProductById(intent.getIntExtra(EXTRA_ID, 0))
        viewModel.garageProduct.observe(this, Observer {
            tvName.text = it.name
            tvPrice.text = "Rp. ${it.price}"
            tvDescription.text = it.description
            if(it.charity){
                rlSignDonationProduct.visibility = View.VISIBLE
            }
            else{
                rlSignDonationProduct.visibility = View.GONE
            }
            Glide.with(this).load(it.imageUrl).into(ivPoster)
        })
    }

    companion object{
        val EXTRA_ID = "id"

        fun newIntent(context: Context, productId: Int): Intent {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra(EXTRA_ID, productId)
            return intent
        }
    }
}
