package dora.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import dora.util.DoraDrawables
import dora.widget.drawables.R

class ShapeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.ShapeView)
        val type = ta.getInt(R.styleable.ShapeView_dview_shapeType, 0)
        val color = ta.getColor(R.styleable.ShapeView_dview_shapeColor, 0xFF000000.toInt())
        val isStroke = ta.getBoolean(R.styleable.ShapeView_dview_isStroke, false)
        val strokeWidth = ta.getDimension(R.styleable.ShapeView_dview_strokeWidth, 6f)
        val cornerRadius = ta.getDimension(R.styleable.ShapeView_dview_cornerRadius, 0f)
        ta.recycle()
        val shape = when (type) {
            0 -> DoraDrawables.roundedRect(color, cornerRadius)
            1 -> DoraDrawables.circle(color)
            2 -> DoraDrawables.createTriangle(color, isStroke, strokeWidth)
            3 -> DoraDrawables.createStar(color, isStroke, strokeWidth)
            4 -> DoraDrawables.createPolygon(color, 6, isStroke, strokeWidth)
            5 -> DoraDrawables.createSector(color, 0f, 120f, isStroke, strokeWidth)
            6 -> DoraDrawables.createHeart(color, isStroke, strokeWidth)
            7 -> DoraDrawables.createArc(color, 0f, 180f, strokeWidth)
            else -> DoraDrawables.roundedRect(color, cornerRadius)
        }
        background = shape
    }
}
