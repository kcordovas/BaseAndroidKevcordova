package com.example.baseandroidkevcordova

import android.app.Application

class BaseAndroidKevCordovaApp : Application() {
    companion object {
        const val SHARED_PREFERENCES_NAME = "BaseAndroidPreferences"
    }
}