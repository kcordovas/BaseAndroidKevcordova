package com.example.baseandroidkevcordova

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    companion object {
        private const val KEY_PREFERENCE = "KEY"
        const val TAG: String = "MainViewModel"
    }
    fun sharedPreferences(valueToSave: String = "ValueToSave") {
        BaseAndroidKevCordovaApp.getKSharedPreferences().apply {
            edit(Pair(KEY_PREFERENCE, valueToSave))
            val valueSaved = getString(KEY_PREFERENCE)
            Log.i(TAG, "sharedPreferences:key:$KEY_PREFERENCE:value:$valueSaved")
        }
    }
}