package com.app.muhrahmatullah.dicodingjetpackmovie.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by muh.rahmatullah on 2019-09-24.
 */
@Parcelize
data class Entity(val title: String,
                  val desc: String,
                  val image: Int,
                  val rating: String): Parcelable