package com.app.muhrahmatullah.dicodingjetpackmovie.di


import com.app.muhrahmatullah.dicodingjetpackmovie.ui.detail.DetailContentFragment
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.movies.MoviesFragment
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.tvseries.TvSeriesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by muh.rahmatullah on 2019-09-13.
 */
@Module
abstract class AppBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideMoviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun provideTvSeriesFragment(): TvSeriesFragment

    @ContributesAndroidInjector
    abstract fun provideDetailFragment(): DetailContentFragment
}