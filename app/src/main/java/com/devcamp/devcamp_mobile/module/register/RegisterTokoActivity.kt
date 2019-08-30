package com.devcamp.devcamp_mobile.module.register

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.common.dto.ShopRegistrationDTO
import com.devcamp.devcamp_mobile.module.Register.RegisterTokoViewModel
import com.devcamp.devcamp_mobile.module.login.LoginViewModel
import com.google.gson.annotations.SerializedName

class RegisterTokoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_toko)

        var name=findViewById<EditText>(R.id.etNamaToko).text.toString()
        var location=findViewById<EditText>(R.id.etLocation).text.toString()
        var phoneNumber=findViewById<EditText>(R.id.etNoHp).text.toString()
        var email=findViewById<EditText>(R.id.etEmail).text.toString()
        var password=findViewById<EditText>(R.id.etPassword).text.toString()
        var confirmPassword=findViewById<EditText>(R.id.etConfirmPass).text.toString()
        var statusDTO:ShopRegistrationDTO = ShopRegistrationDTO(name,location,phoneNumber,email,password,confirmPassword)
        val viewModel = ViewModelProviders.of(this).get(RegisterTokoViewModel::class.java)
        viewModel.getStatusRegistration()
        viewModel.shopStatus.observe(this, Observer {
            Toast.makeText(LoginActivity@this, it.status, Toast.LENGTH_SHORT).show()
        })

//        @SerializedName("name") var name: String,
//        @SerializedName("location") var location: String,
//        @SerializedName("phone_number") var phone_number: String,
//        @SerializedName("email") var email: String?,
//        @SerializedName("password") var password: String?,
//        @SerializedName("user_id") var user_id: String?
    }
}
