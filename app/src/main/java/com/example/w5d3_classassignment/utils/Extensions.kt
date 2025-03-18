package com.example.w5d3_classassignment.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatDate(): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this)?.let {
        SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(it)
    } ?: this
}