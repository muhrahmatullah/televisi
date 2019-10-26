package com.app.muhrahmatullah.dicodingjetpackmovie.data

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by muh.rahmatullah on 2019-10-26.
 */
class RemoteDataSourceTest{

    @Mock
    lateinit var rest: MovieRest

    lateinit var data: RemoteDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        data = RemoteDataSource(rest)
    }

    @Test
    fun fetchMovieTest() {
        data.fetchMovie()
        verify(rest).fetchMovie()
    }

    @Test
    fun fetchTvSeriesTest() {
        data.fetchTvSeries()
        verify(rest).fetchTvSeries()
    }


}