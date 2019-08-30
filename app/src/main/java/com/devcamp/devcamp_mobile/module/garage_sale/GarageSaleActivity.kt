package com.devcamp.devcamp_mobile.module.garage_sale

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

class GarageSaleActivity : AppCompatActivity() {

    private lateinit var viewModel: GarageSaleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage_sale)

        viewModel = ViewModelProviders.of(this).get(GarageSaleViewModel::class.java)
        viewModel.getAllGarageSaleProducts()
        viewModel.garageSaleProduct.observe(this, Observer {
//            Toast.makeText(LoginActivity@this, it.email, Toast.LENGTH_SHORT).show()
        })

        var datas = ArrayList<GarageSaleProduct>()
        datas.add(GarageSaleProduct(0, 0, 0, "Nol", 100000, "nolnolnol", 2, false, false))
        datas.add(GarageSaleProduct(1, 1, 1, "Satu",111111, "satsatsat", 3, false, false))
        datas.add(GarageSaleProduct(2, 2, 2, "Satu",111111, "satsatsat", 3, false, false))
        datas.add(GarageSaleProduct(3, 3, 3, "Satu",111111, "satsatsat", 3, false, false))
        datas.add(GarageSaleProduct(4, 4, 4, "Satu",111111, "satsatsat", 3, false, false))
        datas.add(GarageSaleProduct(5, 5, 5, "Satu",111111, "satsatsat", 3, false, false))
        datas.add(GarageSaleProduct(6, 6, 6, "Satu",111111, "satsatsat", 3, false, false))
        datas.add(GarageSaleProduct(7, 7, 7, "Satu",111111, "satsatsat", 3, false, false))

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        val adapter = GarageSaleProductAdapter(datas)
        val layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setAdapter(adapter)



    }
}
