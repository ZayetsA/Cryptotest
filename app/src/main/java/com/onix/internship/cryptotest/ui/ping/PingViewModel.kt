package com.onix.internship.cryptotest.ui.ping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.onix.internship.cryptotest.data.api.ping.Client
import com.onix.internship.cryptotest.util.DialogFragmentStates
import com.onix.internship.cryptotest.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PingViewModel(private val client: Client) : ViewModel() {

    private val _data = SingleLiveEvent<String>()
    val data: LiveData<String>
        get() = _data

    private val model = PingModel()

    private val _isDataLoading = MutableLiveData(DialogFragmentStates.NO)
    val isDataLoading: LiveData<DialogFragmentStates> = _isDataLoading

    private val _navigationEvent = SingleLiveEvent<NavDirections>()
    val navigationEvent: LiveData<NavDirections> = _navigationEvent

    fun getRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            model.apply {
                _isDataLoading.postValue(DialogFragmentStates.SHOW)
                try {
                    _data.postValue(client.getResponse().geckoSays)
                } catch (e: Exception) {
                    _data.postValue(e.toString())
                }
                _isDataLoading.postValue(DialogFragmentStates.HIDE)
            }
        }
    }

    fun toStubFragment() {
        _navigationEvent.postValue(PingFragmentDirections.actionPingFragmentToStubFragment())
    }
}