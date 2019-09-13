package com.app.muhrahmatullah.dicodingjetpackmovie

import android.app.Application
import com.app.muhrahmatullah.dicodingjetpackmovie.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by muh.rahmatullah on 2019-09-13.
 */
class MovieApp: Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}