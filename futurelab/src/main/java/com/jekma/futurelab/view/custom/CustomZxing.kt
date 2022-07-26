package com.jekma.futurelab.view.custom

import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import java.util.*

class CustomZxing(
    val mViewfinderView: CustomViewfinderView,
    ivScannerBorderStyle: ImageView
) {
    fun changeMaskColor(view: View?, mViewfinderView: CustomViewfinderView) {
        val rnd = Random()
        val color = Color.argb(100, rnd.nextInt(128), rnd.nextInt(128), rnd.nextInt(128))
        mViewfinderView.setMaskColor(color)
    }

    private fun changeLaserVisibility(b: Boolean, mViewfinderView: CustomViewfinderView) {
        this.mViewfinderView.setLaserVisibility(b)
    }

    private fun hasFlash(activity: Activity): Boolean {
        return activity.applicationContext.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
    }

    companion object {
        var ivScannerBorderStyleY = 0f
    }

    init {
        ivScannerBorderStyle.post { ivScannerBorderStyleY = ivScannerBorderStyle.y }
        changeMaskColor(null, mViewfinderView)
        changeLaserVisibility(true, mViewfinderView)
    }
}