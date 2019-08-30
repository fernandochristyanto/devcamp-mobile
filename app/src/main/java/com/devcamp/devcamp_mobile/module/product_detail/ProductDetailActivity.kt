package com.devcamp.devcamp_mobile.module.product_detail

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.devcamp.devcamp_mobile.R

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail)

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