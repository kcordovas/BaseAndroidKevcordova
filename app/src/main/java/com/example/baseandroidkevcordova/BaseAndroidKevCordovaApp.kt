package com.example.baseandroidkevcordova

import android.app.Application
import com.example.baseandroidmodulekevcordova.storage.KSharedPreferences

class BaseAndroidKevCordovaApp : Application() {
    companion object {
        const val SHARED_PREFERENCES_NAME = "BaseAndroidPreferences"
        private lateinit var sharedPref: KSharedPreferences

        fun getKSharedPreferences(): KSharedPreferences {
            return sharedPref
        }
    }

    override fun onCreate() {
        super.onCreate()
        sharedPref = KSharedPreferences(baseContext, SHARED_PREFERENCES_NAME)
    }
}