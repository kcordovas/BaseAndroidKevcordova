package com.example.baseandroidmodulekevcordova.permissions

import android.app.Activity
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

/**
 * Multiple permissions class for use
 * when is required with some permission at same time
 *
 * @param activity is [Activity]
 * @param listener is [KPermissionListener]
 *
 * @author kevc77
 */
class KPermissionMultiple(
    activity: Activity,
    listener: KPermissionListener
) : KPermissionBase(activity, listener) {

    /**
     * Add all permission of a list and clear the before data
     *
     * @param listPermissions is a list where contain all new permissions
     */
    fun addAllPermissionAndClearBefore(listPermissions: MutableList<String>) {
        listMultiplePermissions.clear()
        listMultiplePermissions.addAll(listPermissions)
    }

    /**
     * Add a new permission with a builder design patter to use constant
     *
     * @param permission is either permission of Manifest class
     * @return [KPermissionMultiple]
     */
    fun addNewPermission(permission: String): KPermissionMultiple {
        listMultiplePermissions.add(permission)
        return this
    }

    /**
     * Delete one permission
     *
     * @param permission is either permission of Manifest class
     */
    fun deletePermission(permission: String) {
        listMultiplePermissions.remove(permission)
    }

    override fun check() {
        Dexter.withActivity(activity)
            .withPermissions(listMultiplePermissions)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    listener.permissionCheckedMultiple?.invoke(
                        convertDexterMultiplePermissionResponseInKPermissionMultipleResponse(report)
                    )
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }

            })
            .onSameThread()
            .check()
    }

    /**
     * Convert the Dexter [MultiplePermissionsReport] object
     * in a accessible class for App [com.example.baseandroidmodulekevcordova.permissions.KPermissionListener.KPermissionMultipleResponse]
     *
     * @param report is the [MultiplePermissionsReport] object
     * @return [com.example.baseandroidmodulekevcordova.permissions.KPermissionListener.KPermissionMultipleResponse]
     */
    private fun convertDexterMultiplePermissionResponseInKPermissionMultipleResponse(
        report: MultiplePermissionsReport?
    ): KPermissionListener.KPermissionMultipleResponse? {
        return report?.let { multiplePermissionsReport ->
            val listPermissionGrantedSingleResponse =
                multiplePermissionsReport.grantedPermissionResponses.map { permGrantedRes ->
                    KPermissionListener.KPermissionGrantedSingleResponse(permGrantedRes.permissionName)
                }
            val listPermissionDeniedSingleResponse =
                multiplePermissionsReport.deniedPermissionResponses.map { permDeniedRes ->
                    KPermissionListener.KPermissionDeniedSingleResponse(
                        permDeniedRes.permissionName,
                        permDeniedRes.isPermanentlyDenied
                    )
                }
            KPermissionListener.KPermissionMultipleResponse(
                listPermissionGrantedSingleResponse,
                listPermissionDeniedSingleResponse,
                multiplePermissionsReport.isAnyPermissionPermanentlyDenied,
                multiplePermissionsReport.areAllPermissionsGranted()
            )
        }
    }

}