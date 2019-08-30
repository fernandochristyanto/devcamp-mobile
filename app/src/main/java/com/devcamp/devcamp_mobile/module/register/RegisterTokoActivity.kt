package com.devcamp.devcamp_mobile.module.register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.common.dto.ShopRegistrationDTO
import com.devcamp.devcamp_mobile.data.UserSession
import com.devcamp.devcamp_mobile.module.add_item.AddItemActivity
import com.devcamp.devcamp_mobile.module.register.RegisterTokoViewModel
import com.devcamp.devcamp_mobile.module.login.LoginViewModel
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.annotations.SerializedName

class RegisterTokoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_toko)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val viewModel = ViewModelProviders.of(this).get(RegisterTokoViewModel::class.java)

        btnRegister.setOnClickListener {
            val name=findViewById<TextInputLayout>(R.id.etNamatoko).editText!!.text.toString()
            val location=findViewById<TextInputLayout>(R.id.etLocation).editText!!.text.toString()
            val phoneNumber=findViewById<TextInputLayout>(R.id.etNoHp).editText!!.text.toString()
            val email=findViewById<TextInputLayout>(R.id.etEmail).editText!!.text.toString()
            val password=findViewById<TextInputLayout>(R.id.etPassword).editText!!.text.toString()
            val confirmPassword=findViewById<TextInputLayout>(R.id.etConfirmPass).editText!!.text.toString()

            var statusDTO:ShopRegistrationDTO = ShopRegistrationDTO(name,location,phoneNumber,email,password, null)
            viewModel.registerShop(statusDTO)
        }

        viewModel.user.observe(this, Observer {
            UserSession.setUser(it)
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}
