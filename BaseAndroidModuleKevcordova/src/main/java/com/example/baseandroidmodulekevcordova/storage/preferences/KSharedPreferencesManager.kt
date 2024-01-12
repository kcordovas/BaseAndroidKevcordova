package com.example.baseandroidmodulekevcordova.storage.preferences

import android.content.Context
import com.example.baseandroidmodulekevcordova.storage.KSharedPreferences

open class KSharedPreferencesManager(
    context: Context,
    nameDefaultSharedPreferences: String,
    nameSettingsSharedPreferences: String,
) {

    val prefDefault: KSharedPreferences = KSharedPreferences(
        context =context,
        nameSharedPref = nameDefaultSharedPreferences,
        typeSharedPreferences = KSharedPreferences.EKSharedPreferencesType.DEFAULT
    )

    val prefSettings: KSharedPreferences = KSharedPreferences(
        context = context,
        nameSharedPref = nameSettingsSharedPreferences,
        typeSharedPreferences = KSharedPreferences.EKSharedPreferencesType.SETTINGS
    )
}