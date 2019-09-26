package com.app.muhrahmatullah.dicodingjetpackmovie.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.app.muhrahmatullah.dicodingjetpackmovie.data.FakeRepo
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.TvSeriesEntity
import javax.inject.Inject

/**
 * Created by muhrahmatullah on 2019-09-26.
 */
class TvSeriesViewModel @Inject constructor(private val repo: FakeRepo): ViewModel() {

    private val _tvTrigger = MutableLiveData<Boolean>()

    val tvData : LiveData<List<TvSeriesEntity>> = Transformations.switchMap(_tvTrigger) {
        repo.fetchTvSeries()
    }

    fun triggerTvSeries() {
        _tvTrigger.value = true
    }

}