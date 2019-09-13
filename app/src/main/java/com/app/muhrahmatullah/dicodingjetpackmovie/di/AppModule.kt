package com.app.muhrahmatullah.dicodingjetpackmovie.di

import android.app.Application
import android.content.Context
import com.app.muhrahmatullah.dicodingjetpackmovie.MovieApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by muh.rahmatullah on 2019-09-13.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideApp(application: Application): MovieApp {
        return application as MovieApp
    }


}