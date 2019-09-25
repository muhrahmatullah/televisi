package com.app.muhrahmatullah.dicodingjetpackmovie.movies


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.FragmentMoviesBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.app.muhrahmatullah.dicodingjetpackmovie.util.AppExecutors
import com.app.muhrahmatullah.dicodingjetpackmovie.util.AutoClearedValue
import com.app.muhrahmatullah.dicodingjetpackmovie.util.autoCleared
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MoviesFragment : Fragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    private val moviesViewModel: MoviesViewModel by viewModels {
        vmFactory
    }

    var adapter by autoCleared<MovieAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMoviesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentMoviesBinding.lifecycleOwner = viewLifecycleOwner

        val rvAdapter = MovieAdapter(appExecutors)

        val gridLayoutManager = GridLayoutManager(activity, 2)
        fragmentMoviesBinding.recyclerView.apply{
            layoutManager = gridLayoutManager
            adapter = rvAdapter
        }

        adapter = rvAdapter

        moviesViewModel.triggerMovie()

        moviesViewModel.movieData.observe(viewLifecycleOwner, Observer { movie ->
            adapter.submitList(movie)
        })

    }
}
