package com.app.muhrahmatullah.dicodingjetpackmovie.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Created by muh.rahmatullah on 2019-09-25.
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(vMFactory : VmFactory) : ViewModelProvider.Factory
}