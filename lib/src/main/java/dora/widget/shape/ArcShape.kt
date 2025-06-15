package dora.widget.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.shapes.Shape

/**
 * 弓形。
 */
class ArcShape(private val startAngle: Float, private val sweepAngle: Float, private val thickness: Float) : Shape() {

    override fun draw(canvas: Canvas, paint: Paint) {
        val inset = thickness / 2f
        val rect = RectF(inset, inset, width - inset, height - inset)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = thickness
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(rect, startAngle, sweepAngle, false, paint)
    }
}