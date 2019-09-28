package ru.nikiz.data.extensions

import android.view.View

fun View.toggleVisibility(show: Boolean) {
    visibility = if (show) {
        View.VISIBLE
    } else {
        View.GONE
    }
}