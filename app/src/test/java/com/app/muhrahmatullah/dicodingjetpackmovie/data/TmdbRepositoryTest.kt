package com.app.muhrahmatullah.dicodingjetpackmovie.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by muh.rahmatullah on 2019-10-26.
 */
class TmdbRepositoryTest{

    lateinit var repo: TmdbRepository

    @Mock
    lateinit var data: RemoteDataSource

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repo = TmdbRepository(data)
    }

    @Test
    fun fetchMovieTest() {
        repo.fetchMovie()
        verify(data).fetchMovie()
    }

    @Test
    fun fetchTvSeriesTest() {
        repo.fetchTvSeries()
        verify(data).fetchTvSeries()
    }
}