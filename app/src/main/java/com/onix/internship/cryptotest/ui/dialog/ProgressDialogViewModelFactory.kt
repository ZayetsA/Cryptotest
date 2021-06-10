package com.onix.internship.cryptotest.ui.dialog

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ProgressDialogViewModelFactory(private val arguments: Bundle?) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProgressDialogViewModel::class.java)) {
            return ProgressDialogViewModel(arguments) as T
        }
        throw IllegalArgumentException("Unknown view model class!")
    }
}