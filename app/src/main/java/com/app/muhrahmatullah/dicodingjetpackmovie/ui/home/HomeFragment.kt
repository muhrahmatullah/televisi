package com.app.muhrahmatullah.dicodingjetpackmovie.ui.home
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.app.muhrahmatullah.dicodingjetpackmovie.FragmentViewPagerAdapter

import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.FragmentHomeBinding
import com.app.muhrahmatullah.dicodingjetpackmovie.di.Injectable
import com.app.muhrahmatullah.dicodingjetpackmovie.testing.OpenForTesting
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.movies.MoviesFragment
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.tvseries.TvSeriesFragment
import com.google.android.material.tabs.TabLayoutMediator

@OpenForTesting
class HomeFragment : Fragment(){

    private lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagerAdapter = FragmentViewPagerAdapter(childFragmentManager, lifecycle)
        pagerAdapter.populateFragment(MoviesFragment(), "Popular Movie")
        pagerAdapter.populateFragment(TvSeriesFragment(), "Tv Series")

        homeBinding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(homeBinding.tabs, homeBinding.viewPager,
            TabLayoutMediator.OnConfigureTabCallback
            { tab, position -> tab.text = pagerAdapter.getPageTitle(position) }).attach()

    }


}
