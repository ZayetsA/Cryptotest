package com.onix.internship.cryptotest.ui.dialog

import android.os.Bundle
import androidx.lifecycle.ViewModel

class ProgressDialogViewModel(private val arguments: Bundle?) : ViewModel() {
    var model = ProgressDialogModel()

    init {
        model.apply {
            if (arguments != null) {
                title = arguments.get("Title") as String
                message = arguments.get("Message") as String
            }
        }
    }
}