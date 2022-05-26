package com.example.baseandroidkevcordova

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.baseandroidkevcordova.databinding.ActivityMainBinding
import com.example.baseandroidmodulekevcordova.permissions.*
import java.util.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.apply {
            activity = this@MainActivity
            viewmodel = viewModel
        }
    }

    fun requestPermissionSingle() {
        val permissionListener = KPermissionListener
        val permissionManagerSingle = KPermissionFactory(this).getPermissionManager(
            KPermissionFactory.ETypePermissionManager.SINGLE,
            permissionListener
        )
        permissionManagerSingle.permission = Manifest.permission.CAMERA
        permissionManagerSingle.check()
        permissionListener.permissionGrantedOne = {
            Log.i(TAG, "requestPermission:Single:GRANTED")
            Log.i(TAG, "requestPermission:Single:name:${it?.permissionName}")
        }
        permissionListener.permissionDeniedOne = {
            Log.i(TAG, "requestPermission:Single:DENIED")
            Log.i(TAG, "requestPermission:Single:DENIED:name:${it?.permissionName}")
            Log.i(TAG, "requestPermission:Single:DENIED:isPermanent:${it?.isDeniedPermanently}")
        }
    }

    fun requestPermissionMultiple() {
        val permissionListener = KPermissionListener
        val permissionManagerMultiple: KPermissionMultiple =
            KPermissionFactory(this).getPermissionManager(
                KPermissionFactory.ETypePermissionManager.MULTIPLE,
                permissionListener
            ) as KPermissionMultiple

        permissionManagerMultiple.addAllPermissionAndClearBefore(
            mutableListOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        )
        permissionManagerMultiple.check()
        permissionListener.permissionCheckedMultiple = {
            Log.i(TAG, "requestPermission:Multiple:list granted:${it?.grantedPermissionList?.size}")
            Log.i(TAG, "requestPermission:Multiple:list denied:${it?.deniedPermissionList?.size}")
            Log.i(
                TAG,
                "requestPermission:Multiple:isAnyPermissionPermanentlyDenied?:${it?.isAnyPermissionPermanentlyDenied}"
            )
            Log.i(
                TAG,
                "requestPermission:Multiple:areAllPermissionGranted?${it?.areAllPermissionGranted}"
            )
        }
    }
}