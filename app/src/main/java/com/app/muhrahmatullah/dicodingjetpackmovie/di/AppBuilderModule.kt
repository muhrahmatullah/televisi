package com.app.muhrahmatullah.dicodingjetpackmovie.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.muhrahmatullah.dicodingjetpackmovie.movies.MoviesFragment
import com.app.muhrahmatullah.dicodingjetpackmovie.movies.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by muh.rahmatullah on 2019-09-13.
 */
@Module
abstract class AppBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideMoviesFragment(): MoviesFragment
}