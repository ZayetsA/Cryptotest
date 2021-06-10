package com.onix.internship.cryptotest.ui.ping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onix.internship.cryptotest.data.api.ping.Helper
import com.onix.internship.cryptotest.data.model.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PingViewModel(private val helper: Helper) : ViewModel() {

    private val _data = MutableLiveData<Response>()
    val data: LiveData<Response>
        get() = _data

    fun getRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(helper.getResponse())
        }
    }
}