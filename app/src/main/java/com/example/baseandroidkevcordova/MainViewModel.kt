package com.example.baseandroidkevcordova

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.baseandroidmodulekevcordova.constants.KGeneralConstants
import com.example.baseandroidmodulekevcordova.utils.KCalendarUtils
import java.util.*

class MainViewModel : ViewModel() {
    companion object {
        private const val KEY_PREFERENCE = "KEY"
        const val TAG: String = "MainViewModel"
    }

    fun sharedPreferences() {
        BaseAndroidKevCordovaApp.getKSharedPreferences().apply {
            edit(Pair(KEY_PREFERENCE, "valueToSave"))
            val valueSaved = getString(KEY_PREFERENCE)
            Log.i(TAG, "sharedPreferences:key:$KEY_PREFERENCE:value:$valueSaved")
        }
    }

    fun dateFormat() {
        val todayName = KCalendarUtils.formatDateWithPattern(
            Calendar.getInstance(),
            KCalendarUtils.PATTERN_DATE_COMPLETE_WITH_HOUR
        )
        val replaceDate =
            KCalendarUtils.replaceDateStringDividers(todayName, KGeneralConstants.DIVIDER)
        val replaceTime = KCalendarUtils.replaceDateStringDividers(
            todayName,
            KCalendarUtils.DIVIDER_DATE_ORIGINAL,
            KCalendarUtils.DIVIDER_DATE_ORIGINAL
        )
        Log.i(TAG, "dateFormat: $todayName")
        Log.i(TAG, "dateFormat:replace Divider date: $replaceDate")
        Log.i(TAG, "dateFormat:replace Divider date: $replaceTime")
    }
}