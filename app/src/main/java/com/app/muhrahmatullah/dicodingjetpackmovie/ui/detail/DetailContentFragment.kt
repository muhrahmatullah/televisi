package com.app.muhrahmatullah.dicodingjetpackmovie.ui.detail

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider

import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.databinding.DetailContentFragmentBinding
import com.app.muhrahmatullah.dicodingjetpackmovie.util.EspressoIdlingResource
import com.app.muhrahmatullah.dicodingjetpackmovie.util.ImageLoadingListener
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailContentFragment : Fragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: DetailContentViewModel by viewModels {
        vmFactory
    }

    lateinit var detailContentFragmentBinding: DetailContentFragmentBinding

    private var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        EspressoIdlingResource.increment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailContentFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.detail_content_fragment, container, false
        )

        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(R.transition.move)

        detailContentFragmentBinding.listener = object: ImageLoadingListener {
            override fun onSuccess() {
              //image loading success
                startPostponedEnterTransition()
                if (!EspressoIdlingResource.espressoIdlingResource.isIdleNow) {
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailed() {
                //image loading error
                startPostponedEnterTransition()
                if (!EspressoIdlingResource.espressoIdlingResource.isIdleNow) {
                    EspressoIdlingResource.decrement()
                }
            }
        }

        // Animation Watchdog - Make sure we don't wait longer than a second for the image to be load
        handler.postDelayed(1000) {
            startPostponedEnterTransition()
        }
        postponeEnterTransition()
        return detailContentFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val params = arguments?.let { DetailContentFragmentArgs.fromBundle(it) }
        detailContentFragmentBinding.entity = params?.entity
    }
}
