package com.app.muhrahmatullah.dicodingjetpackmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.ActivityHomeBinding
import com.app.muhrahmatullah.dicodingjetpackmovie.di.Injectable
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.movies.MoviesFragment
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.tvseries.TvSeriesFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.elevation = 0f
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

    }
}
