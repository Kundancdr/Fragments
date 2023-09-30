package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val bottomnav:BottomNavigationView = findViewById(R.id.bottom_nav)
       openFragment(MyFirstFragment())

        bottomnav.setOnNavigationItemSelectedListener {
            val id = it.itemId
            when(id) {
                R.id.menu_home -> {
                   openFragment(MyFirstFragment())
                   Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show()

                }
                R.id.menu_profile -> {
                    openFragment(MySecondFragment())
                    Toast.makeText(this, "profile Selected", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_cart ->{
                    openFragment(MyThirdFragment())
                   Toast.makeText(this,"cart Selected",Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun openFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv,fragment)
            .commit()

    }
}
