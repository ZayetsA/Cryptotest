package com.onix.internship.cryptotest.ui.ping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.internship.cryptotest.data.api.ping.Client

@Suppress("UNCHECKED_CAST")
class PingViewModelFactory(private val client: Client) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PingViewModel::class.java)) {
            return PingViewModel(client) as T
        }
        throw IllegalArgumentException("Unknown view model class!")
    }
}