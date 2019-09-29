package com.app.muhrahmatullah.dicodingjetpackmovie.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider

import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.DetailContentFragmentBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailContentFragment : Fragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: DetailContentViewModel by viewModels {
        vmFactory
    }

    lateinit var detailContentFragmentBinding: DetailContentFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailContentFragmentBinding = DataBindingUtil.inflate(inflater,
            R.layout.detail_content_fragment, container, false)
        return detailContentFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val params = arguments?.let { DetailContentFragmentArgs.fromBundle(it) }
        detailContentFragmentBinding.entity = params?.entity
    }
}
