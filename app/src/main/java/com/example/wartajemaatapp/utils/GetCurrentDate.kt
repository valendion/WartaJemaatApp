package com.example.wartajemaatapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object GetCurrentDate {

    @SuppressLint("SimpleDateFormat")
    fun getDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd MMMM yyyy");
        return dateFormat.format(calendar.time)
    }

}