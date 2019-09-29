package com.app.muhrahmatullah.dicodingjetpackmovie.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.app.muhrahmatullah.dicodingjetpackmovie.data.FakeRepo
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.Entity
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by muh.rahmatullah on 2019-09-29.
 */
class MoviesViewModelTest {

    lateinit var viewModel: MoviesViewModel

    @Mock
    lateinit var observer: Observer<List<Entity>>

    @Mock
    lateinit var repo: FakeRepo

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesViewModel(repo)
    }

    @Test
    fun triggerMovieTest() {
        viewModel.data.observeForever(observer)
        viewModel.triggerMovie()
        verify(repo).fetchMovie()
    }
}