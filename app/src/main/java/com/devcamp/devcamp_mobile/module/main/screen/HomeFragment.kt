package com.devcamp.devcamp_mobile.module.main.screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.module.garage_sale.GarageSaleActivity
import org.w3c.dom.Text

class HomeFragment: Fragment()  {
    lateinit var tvCheckGrgSales: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        tvCheckGrgSales = view.findViewById(R.id.tvLihatGarageSales)

        tvCheckGrgSales.setOnClickListener {
            val intent = Intent(context, GarageSaleActivity::class.java)
            context?.startActivity(intent)
        }
        return view
    }
}