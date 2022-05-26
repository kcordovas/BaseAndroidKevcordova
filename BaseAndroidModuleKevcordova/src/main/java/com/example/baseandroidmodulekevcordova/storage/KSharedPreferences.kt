package com.example.baseandroidmodulekevcordova.storage

import android.content.Context
import androidx.preference.PreferenceManager
import com.example.baseandroidmodulekevcordova.constants.KGeneralConstants
import java.lang.IllegalArgumentException
import java.lang.NullPointerException

class KSharedPreferences(
    context: Context?,
    nameSharedPref: String = "KSharedPreferences",
    typeSharedPreferences: EKSharedPreferencesType = EKSharedPreferencesType.DEFAULT
) {
    companion object {
        private const val TAG = "KSharedPreferences"
    }
    private var sharedPref = if (typeSharedPreferences == EKSharedPreferencesType.SETTINGS) {
        context?.let { PreferenceManager.getDefaultSharedPreferences(it) }
            ?: throw NullPointerException("$TAG:context is null")
    } else {
        context?.getSharedPreferences(nameSharedPref, Context.MODE_PRIVATE)
    }

    fun edit(pair: Pair<String, *>) {
        with(sharedPref?.edit()) {
            when (pair.second) {
                is String -> this?.putString(pair.first, (pair.second as String))
                is Int -> this?.putInt(pair.first, (pair.second as Int))
                is Boolean -> this?.putBoolean(pair.first, (pair.second as Boolean))
                is Float -> this?.putFloat(pair.first, (pair.second as Float))
                is Long -> this?.putLong(pair.first, (pair.second as Long))
                else -> throw IllegalArgumentException("Second value is not accepted in Shared Preferences")
            }
            this?.apply()
        }
    }

    fun getString(key: String): String? = sharedPref?.getString(key, KGeneralConstants.EMPTY)
    fun getBoolean(key: String): Boolean? = sharedPref?.getBoolean(key, false)
    fun getInt(key: String): Int? = sharedPref?.getInt(key, KGeneralConstants.NUMBER_ONE_NEGATIVE)
    fun getFloat(key: String): Float? = sharedPref?.getFloat(key, -1f)
    fun getLong(key: String): Long? = sharedPref?.getLong(key, -1L)

    enum class EKSharedPreferencesType {
        DEFAULT,
        SETTINGS
    }
}

