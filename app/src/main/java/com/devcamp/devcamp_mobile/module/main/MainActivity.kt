package com.devcamp.devcamp_mobile.module.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import butterknife.BindView
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.common.User
import com.devcamp.devcamp_mobile.data.UserSession
import com.devcamp.devcamp_mobile.module.main.screen.HomeFragment
import com.devcamp.devcamp_mobile.module.main.screen.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView
    lateinit var container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UserSession.setUser(User(1, "devcamp@devcamp", "devcamp"))

        bottomNav = findViewById(R.id.bottomNav)
        container = findViewById(R.id.container )

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
            .commit()

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment())
                        .commit()
                    true
                }
                R.id.item_profile  -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, UserFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
