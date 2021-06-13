package com.onix.internship.cryptotest.ui.ping

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

data class PingModel(var _result: String = "bitch") : BaseObservable() {
    @Bindable
    var result: String = _result
        set(value) {
            _result = value
            field = value
            notifyPropertyChanged(BR.result)
        }
}