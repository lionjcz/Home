package com.jekma.futurelab.view.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import com.journeyapps.barcodescanner.ViewfinderView

/**
 * <pre>
 * author : jackyzheng
 * e-mail : xxx@xx
 * time : 2021/09/24
 * desc :
 * version: 1.0
</pre> *
 */
class CustomViewfinderView(context: Context?, attrs: AttributeSet?) :
    ViewfinderView(context, attrs) {
    override fun onDraw(canvas: Canvas) {
        refreshSizes()
        if (framingRect == null || previewSize == null) {
            return
        }
        val frame = framingRect
        val previewSize = previewSize
        val width = canvas.width
        val height = canvas.height

        // Draw the exterior (i.e. outside the framing rect) darkened
        paint.color = if (resultBitmap != null) resultColor else maskColor
        canvas.drawRect(0f, 0f, width.toFloat(), frame.top.toFloat(), paint)
        canvas.drawRect(0f, frame.top.toFloat(), frame.left.toFloat(), (frame.bottom + 1).toFloat(), paint)
        canvas.drawRect((frame.right + 1).toFloat(), frame.top.toFloat(), width.toFloat(), (frame.bottom + 1).toFloat(), paint)
        canvas.drawRect(0f, (frame.bottom + 1).toFloat(), width.toFloat(), height.toFloat(), paint)
        if (resultBitmap != null) {
            // Draw the opaque result bitmap over the scanning rectangle
            paint.alpha = CURRENT_POINT_OPACITY
            canvas.drawBitmap(resultBitmap, null, frame, paint)
        }
        else {
            // If wanted, draw a red "laser scanner" line through the middle to show decoding is active
            if (laserVisibility) {
                paint.color = laserColor
                paint.alpha = SCANNER_ALPHA[scannerAlpha]
                scannerAlpha = (scannerAlpha + 1) % SCANNER_ALPHA.size
                val middle = frame.height() / 2 + frame.top
                canvas.drawRect((frame.left + 2).toFloat(), (middle - 1).toFloat(), (frame.right - 1).toFloat(), (middle + 2).toFloat(), paint)
            }
            val scaleX = width / previewSize.width.toFloat()
            val scaleY = height / previewSize.height.toFloat()

            // draw the last possible result points
            if (!lastPossibleResultPoints.isEmpty()) {
                paint.alpha = CURRENT_POINT_OPACITY / 2
                paint.color = resultPointColor
                val radius = POINT_SIZE / 2.0f
                for (point in lastPossibleResultPoints) {
                    canvas.drawCircle((point.x * scaleX).toInt()
                        .toFloat(), (point.y * scaleY).toInt().toFloat(), radius, paint)
                }
                lastPossibleResultPoints.clear()
            }

            // draw current possible result points
            if (!possibleResultPoints.isEmpty()) {
                paint.alpha = CURRENT_POINT_OPACITY
                paint.color = resultPointColor
                for (point in possibleResultPoints) {
                    canvas.drawCircle((point.x * scaleX).toInt()
                        .toFloat(), (point.y * scaleY).toInt()
                        .toFloat(), POINT_SIZE.toFloat(), paint)
                }

                // swap and clear buffers
                val temp = possibleResultPoints
                possibleResultPoints = lastPossibleResultPoints
                lastPossibleResultPoints = temp
                possibleResultPoints.clear()
            }

            // Request another update at the animation interval, but only repaint the laser line,
            // not the entire viewfinder mask.
            postInvalidateDelayed(ANIMATION_DELAY, frame.left - POINT_SIZE, frame.top - POINT_SIZE, frame.right + POINT_SIZE, frame.bottom + POINT_SIZE)
        }
        maskColor = Color.TRANSPARENT
    }
}