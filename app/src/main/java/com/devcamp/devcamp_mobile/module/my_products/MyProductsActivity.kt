package com.devcamp.devcamp_mobile.module.my_products

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.devcamp.devcamp_mobile.R
import androidx.lifecycle.Observer
import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.module.main.MainActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.devcamp.devcamp_mobile.data.UserSession
import com.devcamp.devcamp_mobile.module.add_item.AddItemActivity

class MyProductsActivity : AppCompatActivity() {

    private lateinit var viewModel: MyProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_products)

        val addItemMyProducts = findViewById<Button>(R.id.addItemMyProducts)
        addItemMyProducts.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
        }

        viewModel = ViewModelProviders.of(this).get(MyProductsViewModel::class.java)
        viewModel.getMyProducts(UserSession.getUser()!!.id)
        viewModel.myProducts.observe(this, Observer {
            val recyclerView = findViewById(R.id.recyclewViewMyProducts) as RecyclerView
            val adapter = MyProductsAdapter(it)
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        })
    }
}
