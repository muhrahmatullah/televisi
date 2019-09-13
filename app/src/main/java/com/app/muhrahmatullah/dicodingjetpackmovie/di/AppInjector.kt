package com.app.muhrahmatullah.dicodingjetpackmovie.di

import com.app.muhrahmatullah.dicodingjetpackmovie.MovieApp

/**
 * Created by muh.rahmatullah on 2019-09-13.
 */
class AppInjector {
    companion object {
        fun init(app: MovieApp){
            DaggerAppComponent
                .builder()
                .application(app)
                .build()
                .inject(app)
        }
    }
}