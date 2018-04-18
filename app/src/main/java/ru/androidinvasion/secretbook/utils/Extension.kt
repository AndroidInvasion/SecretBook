package ru.androidinvasion.secretbook.utils

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.widget.Toast

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

fun Context.toast(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_LONG).show()
}

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

@ColorInt
@Suppress("DEPRECATION")
fun Context.getColorOld(@ColorRes resId: Int): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.resources.getColor(resId, this.theme)
    } else {
        this.resources.getColor(resId)
    }
}

val Float.dp: Float
    get() = (this / Resources.getSystem().displayMetrics.density)
val Float.px: Float
    get() = (this * Resources.getSystem().displayMetrics.density)