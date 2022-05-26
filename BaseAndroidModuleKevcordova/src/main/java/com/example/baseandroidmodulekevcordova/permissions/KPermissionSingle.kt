package com.example.baseandroidmodulekevcordova.permissions

import android.app.Activity
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener

/**
 * Permission Single class for create a Manager
 * only for request of ONE permission
 *
 * @param activity is [Activity]
 * @param listener is [KPermissionListener]
 *
 * @author kevc77
 */
class KPermissionSingle(
    activity: Activity,
    listener: KPermissionListener
) : KPermissionBase(activity, listener) {

    override fun check() {
        Dexter.withActivity(activity)
            .withPermission(permission)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    listener.permissionGrantedOne?.invoke(
                        response?.let {
                            KPermissionListener.KPermissionGrantedSingleResponse(response.permissionName)
                        }
                    )
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                    listener.permissionDeniedOne?.invoke(
                        response?.let {
                            KPermissionListener.KPermissionDeniedSingleResponse(
                                response.permissionName,
                                response.isPermanentlyDenied
                            )
                        }
                    )
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }

            })
            .onSameThread()
            .check()
    }
}