package com.example.wartajemaatapp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.example.wartajemaatapp.R
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
//        val date: Date? = df.parse("dd-MM-yyyy")
        Log.e("date", input)
        return dateNow
    }

    @SuppressLint("SimpleDateFormat")
    fun changeFormatStringDate(input: String): String {

        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = df.parse(input)

        val dateFormat: DateFormat = SimpleDateFormat("dd MMMM yyyy")
        val dateNow: String = dateFormat.format(date)
//        val date: Date? = df.parse("dd-MM-yyyy")
        Log.e("date", input)
        return dateNow

    }

    @SuppressLint("SimpleDateFormat")
    fun changeFormatTime(input: String): String {
        val df: DateFormat = SimpleDateFormat("H:mm:ss")
        val time = df.parse(input)

        val dateFormat: DateFormat = SimpleDateFormat("H:mm")
        val timeNow: String = dateFormat.format(time)
//        val date: Date? = df.parse("dd-MM-yyyy")
        Log.e("time", timeNow)
        return timeNow
    }

    @SuppressLint("SimpleDateFormat")
    fun getDayInDate(input: String, context: Context):String{
        var inFormat = SimpleDateFormat(context.resources.getString(R.string.formaat_date_indonesia))
        val date: Date? = inFormat.parse(input)
        var outFormat = SimpleDateFormat("EEEE")
        var goal: String = outFormat.format(date)
        return goal
    }

}