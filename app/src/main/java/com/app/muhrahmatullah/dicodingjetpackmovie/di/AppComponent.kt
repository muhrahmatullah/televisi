package com.app.muhrahmatullah.dicodingjetpackmovie.di

import android.app.Application
import com.app.muhrahmatullah.dicodingjetpackmovie.MovieApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by muh.rahmatullah on 2019-09-13.
 */
@Singleton
@Component(
    modules = [AppModule::class,
        AppBuilderModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        AndroidSupportInjectionModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: MovieApp)

}