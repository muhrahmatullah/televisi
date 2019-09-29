package com.app.muhrahmatullah.dicodingjetpackmovie.ui.tvseries

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
class TvSeriesViewModelTest {

    lateinit var viewModel: TvSeriesViewModel

    @Mock
    lateinit var observer: Observer<List<Entity>>

    @Mock
    lateinit var repo: FakeRepo

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TvSeriesViewModel(repo)
    }

    @Test
    fun triggerTvSeriesTest() {
        viewModel.tvData.observeForever(observer)
        viewModel.triggerTvSeries()
        verify(repo).fetchTvSeries()
    }
}