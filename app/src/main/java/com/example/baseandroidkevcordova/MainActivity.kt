package com.example.baseandroidkevcordova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.baseandroidkevcordova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.buttonSharedPreferences.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.buttonSharedPreferences.id -> viewModel.sharedPreferences("Hello SharedPreferences")
        }
    }
}