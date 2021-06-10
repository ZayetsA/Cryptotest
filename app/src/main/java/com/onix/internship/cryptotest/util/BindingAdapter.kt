package com.onix.internship.cryptotest.util

import android.view.View
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter

@BindingAdapter("setVisibility")
fun LinearLayout.setVisibility(value: Boolean) {
    visibility = if (value) View.VISIBLE else View.GONE
}