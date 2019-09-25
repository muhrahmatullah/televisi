package com.app.muhrahmatullah.dicodingjetpackmovie.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * Created by muh.rahmatullah on 2019-09-26.
 */

object TelevisiBindingAdapter {

    // Use coil instead when started to fetch image from network
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(iv: ImageView, imageId: Int){
        iv.setImageResource(imageId)
    }
}