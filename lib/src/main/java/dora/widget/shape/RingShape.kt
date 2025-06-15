package dora.widget.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.shapes.Shape

/**
 * 环形。
 */
class RingShape(private val thickness: Float = 10f) : Shape() {

    override fun draw(canvas: Canvas, paint: Paint) {
        val radius = width.coerceAtMost(height) / 2f
        val cx = width / 2f
        val cy = height / 2f
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = thickness
        canvas.drawCircle(cx, cy, radius - thickness / 2, paint)
    }
}