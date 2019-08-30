package com.devcamp.devcamp_mobile.module.main.screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.module.my_products.MyProductsActivity

class UserFragment : Fragment(){
    lateinit var btnGarageSale: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_userprofile, container, false)
        btnGarageSale = view.findViewById(R.id.btnMyGarageSales)

        btnGarageSale.setOnClickListener {
            val intent = Intent(context, MyProductsActivity::class.java)
            context?.startActivity(intent)
        }

        return view
    }
}