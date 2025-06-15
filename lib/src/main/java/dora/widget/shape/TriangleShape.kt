package dora.widget.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.shapes.Shape

/**
 * 三角形。
 */
class TriangleShape : Shape() {

    override fun draw(canvas: Canvas, paint: Paint) {
        val path = Path()
        path.moveTo(width / 2f, 0f)
        path.lineTo(0f, height.toFloat())
        path.lineTo(width.toFloat(), height.toFloat())
        path.close()
        canvas.drawPath(path, paint)
    }
}
