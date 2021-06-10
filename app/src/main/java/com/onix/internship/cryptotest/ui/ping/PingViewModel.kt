package com.onix.internship.cryptotest.ui.ping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onix.internship.cryptotest.data.api.ping.Helper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PingViewModel(private val helper: Helper) : ViewModel() {

    private val _data = MutableLiveData<String?>()
    val data: LiveData<String?>
        get() = _data

    private val _isDataLoading = MutableLiveData(false)
    val isDataLoading: LiveData<Boolean> = _isDataLoading

    fun getRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            _isDataLoading.postValue(true)
            _data.postValue(helper.getResponse().geckoSays)
            _isDataLoading.postValue(false)
        }
    }
}