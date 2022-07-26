package com.jekma.futurelab.view.custom

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import com.journeyapps.barcodescanner.BarcodeView

/**
 * <pre>
 * author : jackyzheng
 * e-mail : xxx@xx
 * time : 2021/09/24
 * desc :
 * version: 1.0
</pre> *
 */
class CustomBarcodePreview(context: Context?, attrs: AttributeSet?) : BarcodeView(context, attrs) {
    override fun calculateFramingRect(container: Rect, surface: Rect): Rect {
        // intersection is the part of the container that is used for the preview
        val intersection = Rect(container)
        val intersects = intersection.intersect(surface)

        // [Custom] Get private variables by getter
        val framingRectSize = framingRectSize
        val marginFraction = marginFraction
        if (framingRectSize != null) {
            // Specific size is specified. Make sure it's not larger than the container or surface.
            val horizontalMargin = Math.max(0, (intersection.width() - framingRectSize.width) / 2)
            val verticalMargin = Math.max(0, (intersection.height() - framingRectSize.height) / 2)
            intersection.inset(horizontalMargin, verticalMargin)
            val newX = CustomZxing.ivScannerBorderStyleY - verticalMargin
            intersection.offset(0, newX.toInt())
            return intersection
        }
        // margin as 10% (default) of the smaller of width, height
        val margin =
            Math.min(intersection.width() * marginFraction, intersection.height() * marginFraction)
                .toInt()
        intersection.inset(margin, margin)
        if (intersection.height() > intersection.width()) {
            // We don't want a frame that is taller than wide.
            intersection.inset(0, (intersection.height() - intersection.width()) / 2)
        }
        return intersection
    }
}

