package com.example.baseandroidkevcordova

import android.app.Application
import android.content.Context
import com.example.baseandroidmodulekevcordova.storage.KSharedPreferences
import com.example.baseandroidmodulekevcordova.storage.preferences.KSharedPreferencesManager

class BaseAndroidKevCordovaApp : Application() {
    companion object {
        private lateinit var sharedPrefManager: MySharedPreferences

        fun getKSharedPreferences(): KSharedPreferences {
            return sharedPrefManager.prefDefault
        }
    }

    override fun onCreate() {
        super.onCreate()
        sharedPrefManager = MySharedPreferences(this)
    }
}

internal class MySharedPreferences(context: Context): KSharedPreferencesManager(
    context = context,
    nameDefaultSharedPreferences = BuildConfig.APPLICATION_ID,
    nameSettingsSharedPreferences = "${BuildConfig.APPLICATION_ID}.SETTINGS"
)