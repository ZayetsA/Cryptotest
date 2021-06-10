package com.onix.internship.cryptotest.ui.dialog

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

data class ProgressDialogModel(
    private var _title: String = "",
    private var _message: String = ""
) : BaseObservable() {
    @Bindable
    var title: String = _title
        set(value) {
            _title = value
            field = value
            notifyPropertyChanged(BR.title)
        }


    @Bindable
    var message: String = _message
        set(value) {
            _message = value
            field = value
            notifyPropertyChanged(BR.message)
        }
}