package me.hgj.jetpackmvvm.demo.viewmodel.request

import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.callback.livedata.event.EventLiveData
import me.hgj.jetpackmvvm.demo.app.network.apiService
import me.hgj.jetpackmvvm.demo.data.model.bean.IntegralResponse
import me.hgj.jetpackmvvm.ext.request
import me.hgj.jetpackmvvm.state.ResultState

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/27
 * 描述　:
 */
class RequestMeViewModel : BaseViewModel() {

    var meData = EventLiveData<ResultState<IntegralResponse>>()

    fun getIntegral() {
        request({ apiService.getIntegral() }, meData)
    }
}