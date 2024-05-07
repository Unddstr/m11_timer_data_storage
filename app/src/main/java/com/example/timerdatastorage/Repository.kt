package com.example.timerdatastorage

import android.content.SharedPreferences

private const val SHARED_PREFS_KEY = "shared_prefs_key"

class Repository(private var prefs: SharedPreferences) {

    private var localValue: String? = null
    private val editor: SharedPreferences.Editor = prefs.edit()

    private fun getDataFromSharedPreference(): String? {
        return prefs.getString(SHARED_PREFS_KEY, null)
    }

    private fun getDataFromLocalVariable(): String? {
        return localValue
    }

    fun saveText(text: String) {
        editor.putString(SHARED_PREFS_KEY, text).apply()
        localValue = text
    }

    fun clearText() {
        editor.clear().apply()
        localValue = " "
    }

    fun getText(): String {
        return when {
            getDataFromLocalVariable() != null -> getDataFromLocalVariable()!!
            getDataFromSharedPreference() != null -> getDataFromSharedPreference()!!
            else -> "no one source doesn't contain string"
        }
    }
}