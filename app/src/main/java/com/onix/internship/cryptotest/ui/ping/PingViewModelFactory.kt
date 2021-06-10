package com.onix.internship.cryptotest.ui.ping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.internship.cryptotest.data.api.ping.Helper

@Suppress("UNCHECKED_CAST")
class PingViewModelFactory(private val helper: Helper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PingViewModel::class.java)) {
            return PingViewModel(helper) as T
        }
        throw IllegalArgumentException("Unknown view model class!")
    }
}