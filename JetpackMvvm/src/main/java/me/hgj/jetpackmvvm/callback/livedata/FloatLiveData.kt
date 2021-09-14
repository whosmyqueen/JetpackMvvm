package me.hgj.jetpackmvvm.callback.livedata

import me.hgj.jetpackmvvm.callback.livedata.event.EventLiveData


/**
 * 作者　: hegaojian
 * 时间　: 2019/12/17
 * 描述　:自定义的Float类型 EventLiveData 提供了默认值，避免取值的时候还要判空
 */
class FloatLiveData(value: Float = 0f) : EventLiveData<Float>() {
    init {
        setValue(value)
    }
}