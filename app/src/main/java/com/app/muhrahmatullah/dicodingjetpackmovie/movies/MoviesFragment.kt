package com.app.muhrahmatullah.dicodingjetpackmovie.movies


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentMoviesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        return fragmentMoviesBinding.root
    }


}
