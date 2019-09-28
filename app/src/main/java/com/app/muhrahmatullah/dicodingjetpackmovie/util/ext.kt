package com.app.muhrahmatullah.dicodingjetpackmovie.util

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

/**
 * Created by muh.rahmatullah on 2019-09-27.
 */

/**
 * Find a [NavController] given a [Fragment]
 *
 * Calling this on a Fragment that is not a [NavHostFragment] or within a [NavHostFragment]
 * will result in an [IllegalStateException]
 */
fun Fragment.findNavController(): NavController =
    NavHostFragment.findNavController(this)