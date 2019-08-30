package com.devcamp.devcamp_mobile.module.my_products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.devcamp.devcamp_mobile.R
import androidx.lifecycle.Observer
import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.module.main.MainActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MyProductsActivity : AppCompatActivity() {

    private lateinit var viewModel: MyProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_products)

        viewModel = ViewModelProviders.of(this).get(MyProductsViewModel::class.java)
        viewModel.getMyProducts(1)
        viewModel.myProducts.observe(this, Observer {
            //            Toast.makeText(LoginActivity@this, it.email, Toast.LENGTH_SHORT).show()
        })

        var datas = ArrayList<GarageSaleProduct>()
        datas.add(GarageSaleProduct(0, 0, 0, "Nol", 100000, "nolnolnol", 2, true, false))
        datas.add(GarageSaleProduct(1, 1, 1, "Satu",111111, "satsatsat", 3, false, false))
        datas.add(GarageSaleProduct(2, 2, 2, "Satu",111111, "satsatsat", 3, true, false))
        datas.add(GarageSaleProduct(3, 3, 3, "Satu",111111, "satsatsat", 3, true, false))
        datas.add(GarageSaleProduct(4, 4, 4, "Satu",111111, "satsatsat", 3, false, false))
        datas.add(GarageSaleProduct(5, 5, 5, "Satu",111111, "satsatsat", 3, true, false))
        datas.add(GarageSaleProduct(6, 6, 6, "Satu",111111, "satsatsat", 3, true, false))
        datas.add(GarageSaleProduct(7, 7, 7, "Satu",111111, "satsatsat", 3, false, false))

        val recyclerView = findViewById(R.id.recyclewViewMyProducts) as RecyclerView
        val adapter = MyProductsAdapter(datas)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setAdapter(adapter)



    }
}
