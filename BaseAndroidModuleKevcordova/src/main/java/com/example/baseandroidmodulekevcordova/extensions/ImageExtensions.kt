package com.example.baseandroidmodulekevcordova.extensions

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import com.bumptech.glide.Glide
import java.io.File

fun ImageView.bindGlideImage(
    urlStr: String?,
    @DrawableRes placeholder: Int,
    @DrawableRes errorPlaceholder: Int,
    typeCrop: GlideTypeCrop = GlideTypeCrop.CENTER_CROP
) {
    glideImage(
        this,
        urlStr,
        placeholder,
        errorPlaceholder,
        typeCrop
    )
}

fun ImageView.bindGlideImage(
    urlStr: Uri?,
    @DrawableRes placeholder: Int,
    @DrawableRes errorPlaceholder: Int,
    typeCrop: GlideTypeCrop = GlideTypeCrop.CENTER_CROP
) {
    glideImage(
        this,
        urlStr,
        placeholder,
        errorPlaceholder,
        typeCrop
    )
}

fun ImageView.bindGlideImage(
    url: File?,
    @DrawableRes placeholder: Int,
    @DrawableRes errorPlaceholder: Int,
    typeCrop: GlideTypeCrop = GlideTypeCrop.CENTER_CROP
) {
    glideImage(
        this,
        url,
        placeholder,
        errorPlaceholder,
        typeCrop
    )
}

fun ImageView.bindGlideImage(
    url: Bitmap?,
    @DrawableRes placeholder: Int,
    @DrawableRes errorPlaceholder: Int,
    typeCrop: GlideTypeCrop = GlideTypeCrop.CENTER_CROP
) {
    glideImage(
        this,
        url,
        placeholder,
        errorPlaceholder,
        typeCrop
    )
}

fun ImageView.bindGlideImage(
    url: Drawable?,
    @DrawableRes placeholder: Int,
    @DrawableRes errorPlaceholder: Int,
    typeCrop: GlideTypeCrop = GlideTypeCrop.CENTER_CROP
) {
    glideImage(
        this,
        url,
        placeholder,
        errorPlaceholder,
        typeCrop
    )
}

fun ImageView.bindGlideImage(
    @RawRes @DrawableRes urlStr: Int,
    @DrawableRes placeholder: Int,
    @DrawableRes errorPlaceholder: Int,
    typeCrop: GlideTypeCrop = GlideTypeCrop.CENTER_CROP
) {
    glideImage(
        this,
        urlStr,
        placeholder,
        errorPlaceholder,
        typeCrop
    )
}

private inline fun <reified T> glideImage(
    imageView: ImageView,
    url: T?,
    @DrawableRes placeholder: Int,
    @DrawableRes errorPlaceholder: Int,
    typeCrop: GlideTypeCrop
) {
    if (url == null) {
        imageView.setImageResource(placeholder)
        return
    }

    val glideBuilder = Glide.with(imageView.context)
        .load(url)
        .placeholder(placeholder)
        .error(errorPlaceholder)

    when (typeCrop) {
        GlideTypeCrop.CENTER_CROP -> glideBuilder.centerCrop()
        GlideTypeCrop.CENTER_INSIDE -> glideBuilder.centerInside()
        GlideTypeCrop.CIRCLE_CROP -> glideBuilder.circleCrop()
        GlideTypeCrop.FIT_CENTER -> glideBuilder.fitCenter()
    }

    glideBuilder.into(imageView)
}

enum class GlideTypeCrop {
    CENTER_CROP,
    CENTER_INSIDE,
    CIRCLE_CROP,
    FIT_CENTER
}