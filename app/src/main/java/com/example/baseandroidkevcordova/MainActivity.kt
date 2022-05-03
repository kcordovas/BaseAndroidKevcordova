package com.example.baseandroidkevcordova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.baseandroidkevcordova.databinding.ActivityMainBinding
import com.example.baseandroidmodulekevcordova.storage.KSharedPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var sharedPref: KSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.buttonSharedPreferences.setOnClickListener(this)
        // SharedPreferences
        sharedPref = KSharedPreferences(this, BaseAndroidKevCordovaApp.SHARED_PREFERENCES_NAME)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.buttonSharedPreferences.id -> viewModel.sharedPreferences(sharedPref, "Hello SharedPreferences")
        }
    }
}