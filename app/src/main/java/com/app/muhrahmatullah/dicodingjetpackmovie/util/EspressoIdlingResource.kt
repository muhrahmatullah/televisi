package com.app.muhrahmatullah.dicodingjetpackmovie.util

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource



/**
 * Created by muh.rahmatullah on 2019-10-26.
 */
internal object EspressoIdlingResource {

    private val RESOURCE = "GLOBAL"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    val espressoIdlingResource: IdlingResource
        get() = espressoTestIdlingResource

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }
}