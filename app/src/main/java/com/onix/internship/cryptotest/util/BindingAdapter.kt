package com.onix.internship.cryptotest.util

import android.view.View
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton

@BindingAdapter("setVisibility")
fun LinearLayout.setVisibility(value: Boolean) {
    visibility = if (value) View.VISIBLE else View.GONE
}

@BindingAdapter("isClickable")
fun MaterialButton.isClickable(state: DialogFragmentStates) {
    isClickable = when (state) {
        DialogFragmentStates.HIDE -> true
        DialogFragmentStates.SHOW -> false
        DialogFragmentStates.NO -> true
    }
}