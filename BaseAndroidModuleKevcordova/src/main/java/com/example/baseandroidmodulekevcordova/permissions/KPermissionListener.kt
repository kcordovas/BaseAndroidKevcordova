package com.example.baseandroidmodulekevcordova.permissions

/**
 * It's a singleton that contain lambda functions for callback of request permission
 * This class contain data classes for management the response that give Dexter library
 * - [KPermissionGrantedSingleResponse] used when a single permission is granted
 * - [KPermissionDeniedSingleResponse] used when a single permission is denied temporal or permanently
 * - [KPermissionMultipleResponse] used when multiple permission are granted or denied, how a list
 *
 * @author kevc77
 */
object KPermissionListener {
    var permissionGrantedOne: ((KPermissionGrantedSingleResponse?) -> Unit)? = null
    var permissionDeniedOne: ((KPermissionDeniedSingleResponse?) -> Unit)? = null

    // Multiple permission
    var permissionCheckedMultiple: ((KPermissionMultipleResponse?) -> Unit)? = null

    data class KPermissionGrantedSingleResponse(val permissionName: String)
    data class KPermissionDeniedSingleResponse(val permissionName: String, val isDeniedPermanently: Boolean)
    data class KPermissionMultipleResponse(
        val grantedPermissionList: List<KPermissionGrantedSingleResponse>,
        val deniedPermissionList: List<KPermissionDeniedSingleResponse>,
        val isAnyPermissionPermanentlyDenied: Boolean,
        val areAllPermissionGranted: Boolean
    )
}