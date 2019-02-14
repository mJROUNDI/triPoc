package com.mjroundi.poc.util

import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText
import android.os.Build
import android.os.Handler
import android.os.Looper
import com.mjroundi.poc.base.BaseContract
import com.mjroundi.poc.ui.league.SearchContract
import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


/**
 * Created by mJroundi on 11/02/2019.
 */
fun EditText.isEmpty(): Boolean = this.text.isEmpty()

fun Context.getCurrentLocale(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.resources.configuration.locales.get(0)
    } else {
        this.resources.configuration.locale
    }
}

fun Context.getCurrentLocaleDisplayName(): String {
    return this.getCurrentLocale().displayName
}

fun Context.getCurrencyCode(): String {
    return Currency.getInstance(this.getCurrentLocale()).currencyCode
}

inline fun SharedPreferences.edit(func : SharedPreferences.Editor.() -> Unit){
    val editor = edit()
    editor.func()
    editor.apply()
}

fun SharedPreferences.Editor.setString(pair : Pair<String, String>) = putString(pair.first, pair.second)
fun SharedPreferences.Editor.setLong(pair : Pair<String, Long>) = putLong(pair.first, pair.second)