package com.example.baseandroidmodulekevcordova.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun Context.showShortToast(message: String) {
    showToast(this, message)
}

fun Context.showLongToast(message: String) {
    showToast(this, message, Toast.LENGTH_SHORT)
}

inline fun <reified T : Activity> Context.startActivityWithIntentApply(body: Intent.() -> Unit) {
    startActivity(Intent(this, T::class.java).apply(body))
}

fun Context.openWebPage(url: String) {
    val webPageUrl = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, webPageUrl)
    packageManager?.let {
        if (it.resolveActivity(intent, 0) != null) {
            startActivity(intent)
        }
    }
}

private fun showToast(
    context: Context,
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(context, message, duration).show()
}