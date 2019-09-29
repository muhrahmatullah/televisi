package com.app.muhrahmatullah.dicodingjetpackmovie.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.Entity
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by muh.rahmatullah on 2019-09-29.
 */
class FakeRepoTest {

    lateinit var fakeRepo: FakeRepo

    @Mock
    lateinit var movieObserver: Observer<List<Entity>>

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        fakeRepo = FakeRepo()
    }

    @Test
    fun fetchMovieTest() {
        fakeRepo.fetchMovie().observeForever(movieObserver)
        fakeRepo.fetchMovie()
        assertEquals(10, fakeRepo.fetchMovie().value?.count())
    }

    @Test
    fun fetchTvSeriesTest() {
        fakeRepo.fetchTvSeries().observeForever(movieObserver)
        fakeRepo.fetchTvSeries()
        assertEquals(10, fakeRepo.fetchTvSeries().value?.count())
    }

}