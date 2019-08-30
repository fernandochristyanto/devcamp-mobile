package com.devcamp.devcamp_mobile.module.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devcamp.devcamp_mobile.R

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.getUserByEmailAndPassword("devcamp", "devcamp")
        viewModel.user.observe(this, Observer {
            Toast.makeText(LoginActivity@this, it.email, Toast.LENGTH_SHORT).show()
        })
    }
}