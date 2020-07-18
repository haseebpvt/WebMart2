package com.android.webmart.util

import android.content.res.Resources

fun convertPixelToDp(pixel: Int): Int {
    return (pixel / Resources.getSystem().displayMetrics.density).toInt()
}

fun convertDpToPixel(dp: Int): Int {
    return (dp * Resources.getSystem().displayMetrics.density).toInt()
}