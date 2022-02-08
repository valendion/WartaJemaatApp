package com.example.wartajemaatapp.utils

import android.content.Context
import android.content.SharedPreferences

class SharePreference(val context: Context) {

    private val PREFS_SETTING = "prefs_SETTING"
    val PREFS_NAME = "prefs_name"
    val PREFS_ORIGIN = "prefs_origin"
    val PREFS_DATE = "prefs_date"

    val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREFS_SETTING, Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, text: String) {

        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putString(KEY_NAME, text)

        editor.apply()
    }

    fun getValueString(KEY_NAME: String): String? {
        return sharedPref.getString(KEY_NAME, null)
    }

    fun clearSharedPreference() {

        val editor: SharedPreferences.Editor = sharedPref.edit()

        //sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

        editor.clear()
        editor.apply()
    }

    fun removeValue(KEY_NAME: String) {

        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.remove(KEY_NAME)
        editor.apply()
    }


}