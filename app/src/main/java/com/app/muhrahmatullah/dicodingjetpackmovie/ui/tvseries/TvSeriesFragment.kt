package com.app.muhrahmatullah.dicodingjetpackmovie.ui.tvseries


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.FragmentTvSeriesBinding
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.ContentAdapter
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.home.HomeFragmentDirections
import com.app.muhrahmatullah.dicodingjetpackmovie.util.AppExecutors
import com.app.muhrahmatullah.dicodingjetpackmovie.util.autoCleared
import com.app.muhrahmatullah.dicodingjetpackmovie.util.findNavController
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TvSeriesFragment : Fragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors


    lateinit var fragmentTvSeriesBinding: FragmentTvSeriesBinding

    private val tvSeriesViewModel: TvSeriesViewModel by viewModels {
        vmFactory
    }

    var adapter by autoCleared<ContentAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvSeriesBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_tv_series, container, false)
        return fragmentTvSeriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentTvSeriesBinding.lifecycleOwner = viewLifecycleOwner
        tvSeriesViewModel.tvData.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        val rvAdapter =
            ContentAdapter(appExecutors) {item ->
                navController().navigate(
                    HomeFragmentDirections.toDetailPage(item)
                )
            }

        val gridLayout = GridLayoutManager(activity, 2)
        fragmentTvSeriesBinding.recyclerView.apply {
            layoutManager = gridLayout
            adapter = rvAdapter
        }

        adapter = rvAdapter

        tvSeriesViewModel.triggerTvSeries()
    }

    fun navController() = findNavController()

}
