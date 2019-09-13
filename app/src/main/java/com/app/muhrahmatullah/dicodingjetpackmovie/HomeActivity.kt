package com.app.muhrahmatullah.dicodingjetpackmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.elevation = 0f
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)



    }
}
