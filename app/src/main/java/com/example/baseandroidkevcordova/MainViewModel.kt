package com.example.baseandroidkevcordova

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.baseandroidmodulekevcordova.storage.KSharedPreferences

class MainViewModel: ViewModel() {
    companion object {
        private const val KEY_PREFERENCE = "KEY"
        const val TAG: String = "MainViewModel"
    }
    fun sharedPreferences(sharedPrefs: KSharedPreferences, valueToSave: String = "ValueToSave") {
        sharedPrefs.edit(Pair(KEY_PREFERENCE, valueToSave))
        val valueSaved = sharedPrefs.getString(KEY_PREFERENCE)
        Log.i(TAG, "sharedPreferences:key:$KEY_PREFERENCE:value:$valueSaved")
    }
}