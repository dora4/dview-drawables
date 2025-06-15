package dora.widget.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.shapes.Shape
import kotlin.math.cos
import kotlin.math.sin

/**
 * 多边形。
 */
class PolygonShape(private val sides: Int) : Shape() {

    override fun draw(canvas: Canvas, paint: Paint) {
        if (sides < 3) return

        val path = Path()
        val midX = width / 2f
        val midY = height / 2f
        val radius = width.coerceAtMost(height) / 2f

        for (i in 0 until sides) {
            val angle = Math.toRadians((360.0 / sides * i - 90))
            val x = (midX + radius * cos(angle)).toFloat()
            val y = (midY + radius * sin(angle)).toFloat()
            if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }
        path.close()
        canvas.drawPath(path, paint)
    }
}