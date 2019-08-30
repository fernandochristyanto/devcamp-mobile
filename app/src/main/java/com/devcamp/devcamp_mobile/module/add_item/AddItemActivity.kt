package com.devcamp.devcamp_mobile.module.add_item

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.common.dto.AddItemRequestDTO
import com.devcamp.devcamp_mobile.data.UserSession
import com.devcamp.devcamp_mobile.module.garage_sale.GarageSaleProductAdapter
import com.devcamp.devcamp_mobile.module.main.MainActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_add_item.*

class AddItemActivity : AppCompatActivity() {

    private lateinit var viewModel: AddItemViewModel
    private var addMore = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        title = "Tambah Product"

        val btnSimpan: Button = findViewById(R.id.btnSimpan)
        val btnSimpanTambah: Button = findViewById(R.id.btnSimpanTambah)

        val txtProductName: TextInputEditText = findViewById(R.id.txtProductNameAddItem)
        val txtPrice: TextInputEditText = findViewById(R.id.txtPriceAddItem)
        val txtStock: TextInputEditText = findViewById(R.id.txtStockAddItem)
        val txtDescription: TextInputEditText = findViewById(R.id.txtDescriptionAddItem)
        val swCharity: Switch = findViewById(R.id.swCharity)

        btnSimpan.setOnClickListener{
            addMore = false
            val addItemRequestDTO = AddItemRequestDTO(
                UserSession.getUser()!!.id,
                txtProductName.text.toString(),
                Integer.parseInt(txtPrice.text.toString()),
                txtDescription.text.toString(),
                Integer.parseInt(txtStock.text.toString()),
                swCharity.isChecked
            )

            viewModel.addNewItems(addItemRequestDTO)
        }

        btnSimpanTambah.setOnClickListener {
            addMore = true
            val addItemRequestDTO = AddItemRequestDTO(
                UserSession.getUser()!!.id,
                txtProductName.text.toString(),
                Integer.parseInt(txtPrice.text.toString()),
                txtDescription.text.toString(),
                Integer.parseInt(txtStock.text.toString()),
                swCharity.isChecked
            )

            viewModel.addNewItems(addItemRequestDTO)
        }

        viewModel = ViewModelProviders.of(this).get(AddItemViewModel::class.java)
        viewModel.garageSaleProduct.observe(this, Observer {
            if(addMore){
                val intent = Intent(this, AddItemActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

    }
}
