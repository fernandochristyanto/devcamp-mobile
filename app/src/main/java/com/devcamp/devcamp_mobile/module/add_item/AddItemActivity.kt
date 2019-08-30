package com.devcamp.devcamp_mobile.module.add_item

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.common.dto.AddItemRequestDTO
import com.devcamp.devcamp_mobile.module.garage_sale.GarageSaleProductAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_add_item.*
import android.widget.CompoundButton
import android.opengl.Visibility
import android.view.View


class AddItemActivity : AppCompatActivity() {

    private lateinit var viewModel: AddItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        val btnSimpan: Button = findViewById(R.id.btnSimpan)
        val btnSimpanTambah: Button = findViewById(R.id.btnSimpanTambah)
        val btnKeluar: Button = findViewById(R.id.btnKeluar)

        val txtProductName: TextInputEditText = findViewById(R.id.txtProductNameAddItem)
        val txtPrice: TextInputEditText = findViewById(R.id.txtPriceAddItem)
        val txtStock: TextInputEditText = findViewById(R.id.txtStockAddItem)
        val txtDescription: TextInputEditText = findViewById(R.id.txtDescriptionAddItem)
        val swCharity: Switch = findViewById(R.id.swCharity)
        val spinnerLembaga = findViewById<Spinner>(R.id.spinnerLembaga)
        swCharity.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                spinnerLembaga.visibility= View.VISIBLE
            } else {
                spinnerLembaga.visibility=View.GONE
                // The toggle is disabled
            }
        };

        btnSimpan.setOnClickListener{
            val addItemRequestDTO = AddItemRequestDTO(
                1,
                1,
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

        })

    }

}
