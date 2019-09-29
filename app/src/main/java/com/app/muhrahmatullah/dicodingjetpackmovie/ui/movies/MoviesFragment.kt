package com.app.muhrahmatullah.dicodingjetpackmovie.ui.movies


import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.FragmentMoviesBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.GridLayoutManager
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.ContentAdapter
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.home.HomeFragmentDirections
import com.app.muhrahmatullah.dicodingjetpackmovie.util.AppExecutors
import com.app.muhrahmatullah.dicodingjetpackmovie.util.autoCleared
import com.app.muhrahmatullah.dicodingjetpackmovie.util.findNavController
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

    var adapter by autoCleared<ContentAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        moviesViewModel.triggerMovie()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMoviesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentMoviesBinding.lifecycleOwner = viewLifecycleOwner

        val rvAdapter = ContentAdapter(appExecutors) { item, imageView ->
            val extras = FragmentNavigatorExtras(
                imageView to item.title
            )
            navController().navigate(
                HomeFragmentDirections.toDetailPage(item), extras
            )
        }

        val gridLayoutManager = GridLayoutManager(activity, 2)
        fragmentMoviesBinding.recyclerView.apply {
            layoutManager = gridLayoutManager
            adapter = rvAdapter
            //delay all the animation untill all data are loaded
            postponeEnterTransition()
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }
        adapter = rvAdapter

        moviesViewModel.data.observe(viewLifecycleOwner, Observer { movie ->
                adapter.submitList(movie)
        })

    }

    fun navController() = findNavController()
}
