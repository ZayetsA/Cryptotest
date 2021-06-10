package com.onix.internship.cryptotest.ui.ping

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onix.internship.cryptotest.data.api.ping.Client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PingViewModel(private val client: Client) : ViewModel() {

    private val _data = MutableLiveData<String>()
    val data: LiveData<String>
        get() = _data

    private val _isDataLoading = MutableLiveData(false)
    val isDataLoading: LiveData<Boolean> = _isDataLoading

    fun getRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            _isDataLoading.postValue(true)
            try {
                val data = client.getResponse().geckoSays
                _data.postValue(data)
            } catch (e: Exception) {
                Log.d("ERROR", "NO DATA")
            }

            _isDataLoading.postValue(false)
        }
    }
}