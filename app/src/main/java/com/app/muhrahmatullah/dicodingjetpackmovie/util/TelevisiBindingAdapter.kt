package com.app.muhrahmatullah.dicodingjetpackmovie.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.api.load

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

    @JvmStatic
    @BindingAdapter("rating")
    fun rating(tv: TextView, text: String){
        tv.text = String.format("Rating: %1s", text)
    }
}