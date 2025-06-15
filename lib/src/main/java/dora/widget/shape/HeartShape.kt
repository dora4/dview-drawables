package dora.widget.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.shapes.Shape

/**
 * 心型。
 */
class HeartShape : Shape() {

    override fun draw(canvas: Canvas, paint: Paint) {
        val path = Path()
        val midX = width / 2f
        val midY = height / 2f
        val scale = width.coerceAtMost(height) / 4f
        path.moveTo(midX, midY + scale)
        path.cubicTo(midX + scale * 2, midY - scale, midX + scale, midY - scale * 2, midX, midY - scale / 2)
        path.cubicTo(midX - scale, midY - scale * 2, midX - scale * 2, midY - scale, midX, midY + scale)
        path.close()
        canvas.drawPath(path, paint)
    }
}
