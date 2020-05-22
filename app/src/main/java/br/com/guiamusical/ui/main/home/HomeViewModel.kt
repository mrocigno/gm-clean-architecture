package br.com.guiamusical.ui.main.home

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import br.com.domain.entity.Home
import br.com.domain.entity.News
import br.com.domain.usecase.HomeUseCase
import br.com.infrastructure.base.AbstractViewModel

class HomeViewModel(
    private val homeUseCase: HomeUseCase
) : AbstractViewModel() {

    private val _homeData = MutableLiveData<List<Any>>()
    val homeData : LiveData<List<Any>> = _homeData

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getHomeData(){
        launchDataLoad(
            block = {
                homeUseCase.refreshLocalData()
                _homeData.value = homeUseCase.getHomeLocalData()
            },
            doOnError = {
                Log.e("DEBUG.TEST", "Tetse", it)
            }
        )
    }

}