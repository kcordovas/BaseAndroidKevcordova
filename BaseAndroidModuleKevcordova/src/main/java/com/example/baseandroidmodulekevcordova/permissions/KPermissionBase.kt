package com.example.baseandroidmodulekevcordova.permissions

import android.app.Activity

/**
 * Base Permission for use in [KPermissionSingle] and [KPermissionMultiple]
 *
 * @param activity is [Activity]
 * @param listener is [KPermissionListener]
 * @constructor Build the permission for use in Dexter
 *
 * @author kevc77
 */
abstract class KPermissionBase(
    open val activity: Activity,
    open val listener: KPermissionListener
) {
    var permission: String = ""
    val listMultiplePermissions: MutableList<String> = mutableListOf()

    /**
     * Abstract functions to execute the runtime request permission
     */
    abstract fun check()
}