package com.example.baseandroidmodulekevcordova.extensions

import android.view.View
import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes

fun View.runDefaultAnimation(@AnimRes idAnimRes: Int) {
    val animation = AnimationUtils.loadAnimation(context, idAnimRes)
    startAnimation(animation)
}