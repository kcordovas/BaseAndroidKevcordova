package com.example.baseandroidmodulekevcordova.permissions

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

/**
 * Factory class for permission Manager of [KPermissionSingle] and [KPermissionMultiple]
 *
 * @param activity is [Activity]
 *
 * @author kevc77
 */
class KPermissionFactory(private val activity: Activity) {

    /**
     * Get the instance of a Manager Permission based on Enum [ETypePermissionManager]
     *
     * @param typePermissionManager is [ETypePermissionManager]
     * @param listener is [KPermissionListener]
     * @return [KPermissionBase] that can to be cast in [KPermissionSingle] or [KPermissionMultiple]
     */
    fun getPermissionManager(
        typePermissionManager: ETypePermissionManager,
        listener: KPermissionListener
    ): KPermissionBase = when (typePermissionManager) {
        ETypePermissionManager.SINGLE -> KPermissionSingle(activity, listener)
        ETypePermissionManager.MULTIPLE -> KPermissionMultiple(activity, listener)
    }

    /**
     * Check permission to validate that is Granted
     *
     * @param permission is Permission to validate
     */
    fun isCheckPermissionGranted(permission: String): Boolean =
        ContextCompat.checkSelfPermission(
            activity,
            permission
        ) == PackageManager.PERMISSION_GRANTED

    /**
     * Enum to identify the different Permission Manager exists
     * - [ETypePermissionManager.SINGLE] is for [KPermissionSingle]
     * - [ETypePermissionManager.MULTIPLE] is for [KPermissionMultiple]
     */
    enum class ETypePermissionManager {
        SINGLE,
        MULTIPLE
    }
}