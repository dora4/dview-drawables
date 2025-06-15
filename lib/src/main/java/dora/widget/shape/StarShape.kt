package dora.widget.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.graphics.drawable.shapes.Shape
import kotlin.math.cos
import kotlin.math.sin

/**
 * 星型。
 */
class StarShape : Shape() {

    override fun draw(canvas: Canvas, paint: Paint) {
        val path = Path()
        val mid = width / 2f
        val radius = width.coerceAtMost(height) / 2f
        val angle = 72.0

        val outerPoints = List(5) { i ->
            val x = (mid + radius * cos(Math.toRadians(angle * i - 90))).toFloat()
            val y = (mid + radius * sin(Math.toRadians(angle * i - 90))).toFloat()
            PointF(x, y)
        }

        val innerRadius = radius * 0.5f
        val innerPoints = List(5) { i ->
            val x = (mid + innerRadius * cos(Math.toRadians(angle * i + 36 - 90))).toFloat()
            val y = (mid + innerRadius * sin(Math.toRadians(angle * i + 36 - 90))).toFloat()
            PointF(x, y)
        }

        for (i in 0..4) {
            if (i == 0) path.moveTo(outerPoints[i].x, outerPoints[i].y)
            path.lineTo(innerPoints[i].x, innerPoints[i].y)
            path.lineTo(outerPoints[(i + 1) % 5].x, outerPoints[(i + 1) % 5].y)
        }
        path.close()

        canvas.drawPath(path, paint)
    }
}