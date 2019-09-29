package com.app.muhrahmatullah.dicodingjetpackmovie.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.decode.DataSource
import coil.request.Request

/**
 * Created by muh.rahmatullah on 2019-09-26.
 */

object TelevisiBindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(iv: ImageView, imageId: Int){
        iv.load(imageId) {
            crossfade(true)
        }
    }

    // Load image with success callback, not so straightforward in coil
    @JvmStatic
    @BindingAdapter("image", "imageLoadListener")
    fun loadImageWithListener(iv: ImageView, imageId: Int, imageListener: ImageLoadingListener?){
        iv.load(imageId) {
            crossfade(true)
            if (imageListener != null) {
                listener(object: Request.Listener{
                    override fun onSuccess(data: Any, source: DataSource) {
                        super.onSuccess(data, source)
                        imageListener.onSuccess()
                    }

                    override fun onError(data: Any, throwable: Throwable) {
                        super.onError(data, throwable)
                        imageListener.onFailed()
                    }
                })
            }
        }
    }


    @JvmStatic
    @BindingAdapter("rating")
    fun rating(tv: TextView, text: String){
        tv.text = String.format("Rating: %1s", text)
    }
}