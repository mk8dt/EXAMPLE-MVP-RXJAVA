package com.mario.superheroe.extension

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mario.superheroe.BuildConfig
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun logError(t: Throwable) {
    if (BuildConfig.DEBUG) {
        Log.d("MGomez", "Error", t)
    }
}

fun ImageView.load(image: String) {
    Glide.with(this.context).load(image)
        .into(this)
}

fun <T> Observable<T>.throttleDefault(): Observable<T> {
    return this.throttleFirst(500, TimeUnit.MILLISECONDS)
}