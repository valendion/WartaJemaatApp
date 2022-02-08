package com.example.wartajemaatapp.utils

import android.annotation.SuppressLint
import android.util.Log
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object FormatDate {

    @SuppressLint("SimpleDateFormat")
    fun changeFormatIndonesianDate(input: String): String {
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = df.parse(input)
        val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy")
        val dateNow: String = dateFormat.format(date)
        return dateNow
    }

    @SuppressLint("SimpleDateFormat")
    fun changeFormatStringDate(input: String): String {
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = df.parse(input)
        val dateFormat: DateFormat = SimpleDateFormat("dd MMMM yyyy")
        return dateFormat.format(date)

    }

    @SuppressLint("SimpleDateFormat")
    fun changeFormatTime(input: String): String {
        val df: DateFormat = SimpleDateFormat("H:mm:ss")
        val time = df.parse(input)
        val dateFormat: DateFormat = SimpleDateFormat("H:mm")
        return dateFormat.format(time)
    }

    @SuppressLint("SimpleDateFormat")
    fun getDayInDate(input: String, formatDate: String):String{
        val inFormat = SimpleDateFormat(formatDate)
        val date: Date? = inFormat.parse(input)
        val outFormat = SimpleDateFormat("EEEE")
        val goal: String = outFormat.format(date)
        return goal
    }


}