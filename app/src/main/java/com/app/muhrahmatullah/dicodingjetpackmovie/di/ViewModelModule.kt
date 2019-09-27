package com.app.muhrahmatullah.dicodingjetpackmovie.di

import androidx.lifecycle.ViewModel
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.movies.MoviesViewModel
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.tvseries.TvSeriesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by muh.rahmatullah on 2019-09-25.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun provideMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TvSeriesViewModel::class)
    abstract fun provideTvSeriesViewModel(tvSeriesViewModel: TvSeriesViewModel): ViewModel
}