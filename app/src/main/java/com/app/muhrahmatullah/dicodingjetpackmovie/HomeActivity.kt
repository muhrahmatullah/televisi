package com.app.muhrahmatullah.dicodingjetpackmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentPagerAdapter
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.ActivityHomeBinding
import com.app.muhrahmatullah.dicodingjetpackmovie.movies.MoviesFragment
import com.app.muhrahmatullah.dicodingjetpackmovie.tvseries.TvSeriesFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.AndroidInjection

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.elevation = 0f
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val pagerAdapter = FragmentViewPagerAdapter(supportFragmentManager, lifecycle)
        pagerAdapter.populateFragment(MoviesFragment(), "Popular Movie")
        pagerAdapter.populateFragment(TvSeriesFragment(), "Tv Series")

        homeBinding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(homeBinding.tabs, homeBinding.viewPager,
            TabLayoutMediator.OnConfigureTabCallback
            { tab, position -> tab.text = pagerAdapter.getPageTitle(position) }).attach()

    }
}
