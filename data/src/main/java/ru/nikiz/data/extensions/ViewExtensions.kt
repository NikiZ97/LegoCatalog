package ru.nikiz.data.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.toggleVisibility(show: Boolean) {
    visibility = if (show) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

fun View.showErrorMessage(errorMessage: String) {
    Snackbar.make(this, errorMessage, Snackbar.LENGTH_SHORT)
}