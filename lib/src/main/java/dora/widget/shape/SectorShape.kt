package dora.widget.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.shapes.Shape

/**
 * 扇形。
 */
class SectorShape(private val startAngle: Float, private val sweepAngle: Float) : Shape() {

    override fun draw(canvas: Canvas, paint: Paint) {
        val rect = RectF(0f, 0f, width.toFloat(), height.toFloat())
        canvas.drawArc(rect, startAngle, sweepAngle, true, paint)
    }
}
