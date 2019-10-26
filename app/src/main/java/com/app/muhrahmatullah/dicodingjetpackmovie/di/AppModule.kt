package com.app.muhrahmatullah.dicodingjetpackmovie.di

import android.app.Activity
import android.app.Application
import android.content.Context
import com.app.muhrahmatullah.dicodingjetpackmovie.BuildConfig
import com.app.muhrahmatullah.dicodingjetpackmovie.MovieApp
import com.app.muhrahmatullah.dicodingjetpackmovie.data.MovieRest
import com.app.muhrahmatullah.dicodingjetpackmovie.rest.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    internal fun provideActivityContext(activity: Activity) : Context = activity


    @Provides
    @Singleton
    internal fun provideNewsClient(): OkHttpClient {
        val builder = OkHttpClient.Builder().addInterceptor { chain ->
            val original = chain.request()
            val httpUrl = original.url()

            val url = httpUrl.newBuilder()
                .addQueryParameter("apiKey", BuildConfig.TMDB_API_KEY)
                .build()

            val requestBuilder = original.newBuilder().url(url)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return builder.build()
    }


    @Provides
    @Singleton
    internal fun provideNetworkRest(okHttpClient: OkHttpClient): MovieRest{
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(okHttpClient)
            .build()
            .create(MovieRest::class.java)
    }


}