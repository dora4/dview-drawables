package dora.util

import android.graphics.*
import android.graphics.drawable.*
import android.view.View
import androidx.annotation.ColorInt
import dora.widget.shape.ArcShape
import dora.widget.shape.HeartShape
import dora.widget.shape.PolygonShape
import dora.widget.shape.RingShape
import dora.widget.shape.SectorShape
import dora.widget.shape.StarShape
import dora.widget.shape.TriangleShape

object DoraDrawables {

    enum class ShapeType {
        RECTANGLE, OVAL, LINE, RING, TRIANGLE, STAR, HEXAGON, SECTOR, HEART, ARC
    }

    fun createShape(
        shape: ShapeType,
        @ColorInt color: Int,
        isStroke: Boolean = false,
        strokeWidth: Float = 6f,
        extraParams: Map<String, Any> = emptyMap()
    ): Drawable {
        return when (shape) {
            ShapeType.RECTANGLE, ShapeType.OVAL, ShapeType.LINE, ShapeType.RING -> {
                GradientDrawable().apply {
                    this.shape = when (shape) {
                        ShapeType.RECTANGLE -> GradientDrawable.RECTANGLE
                        ShapeType.OVAL -> GradientDrawable.OVAL
                        ShapeType.LINE -> GradientDrawable.LINE
                        ShapeType.RING -> GradientDrawable.RING
                        else -> GradientDrawable.RECTANGLE
                    }
                    setColor(color)
                    if (isStroke) setStroke(strokeWidth.toInt(), color)
                }
            }
            ShapeType.TRIANGLE -> createTriangle(color, isStroke, strokeWidth)
            ShapeType.STAR -> createStar(color, isStroke, strokeWidth)
            ShapeType.HEXAGON -> createPolygon(color, 6, isStroke, strokeWidth)
            ShapeType.SECTOR -> {
                val start = extraParams["startAngle"] as? Float ?: 0f
                val sweep = extraParams["sweepAngle"] as? Float ?: 90f
                createSector(color, start, sweep, isStroke, strokeWidth)
            }
            ShapeType.HEART -> createHeart(color, isStroke, strokeWidth)
            ShapeType.ARC -> {
                val start = extraParams["startAngle"] as? Float ?: 0f
                val sweep = extraParams["sweepAngle"] as? Float ?: 90f
                createArc(color, start, sweep, strokeWidth)
            }
        }
    }

    fun createPolygon(@ColorInt color: Int, sides: Int): Drawable {
        require(sides >= 3) { "Polygon must have at least 3 sides." }
        return ShapeDrawable(PolygonShape(sides)).apply {
            paint.color = color
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createStar(@ColorInt color: Int): Drawable {
        return ShapeDrawable(StarShape()).apply {
            paint.color = color
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createTriangle(@ColorInt color: Int): Drawable {
        return ShapeDrawable(TriangleShape()).apply {
            paint.color = color
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createSector(@ColorInt color: Int, startAngle: Float, sweepAngle: Float): Drawable {
        return ShapeDrawable(SectorShape(startAngle, sweepAngle)).apply {
            paint.color = color
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createRing(@ColorInt color: Int, thickness: Float = 10f): Drawable {
        return ShapeDrawable(RingShape(thickness)).apply {
            paint.color = color
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = thickness
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createHeart(@ColorInt color: Int): Drawable {
        return ShapeDrawable(HeartShape()).apply {
            paint.color = color
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createArc(@ColorInt color: Int, startAngle: Float, sweepAngle: Float, thickness: Float): Drawable {
        return ShapeDrawable(ArcShape(startAngle, sweepAngle, thickness)).apply {
            paint.color = color
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = thickness
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createPolygon(@ColorInt color: Int, sides: Int, isStroke: Boolean = false, strokeWidth: Float = 6f): Drawable {
        require(sides >= 3) { "Polygon must have at least 3 sides." }
        return ShapeDrawable(PolygonShape(sides)).apply {
            paint.color = color
            paint.style = if (isStroke) Paint.Style.STROKE else Paint.Style.FILL
            paint.strokeWidth = strokeWidth
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createStar(@ColorInt color: Int, isStroke: Boolean = false, strokeWidth: Float = 6f): Drawable {
        return ShapeDrawable(StarShape()).apply {
            paint.color = color
            paint.style = if (isStroke) Paint.Style.STROKE else Paint.Style.FILL
            paint.strokeWidth = strokeWidth
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createTriangle(@ColorInt color: Int, isStroke: Boolean = false, strokeWidth: Float = 6f): Drawable {
        return ShapeDrawable(TriangleShape()).apply {
            paint.color = color
            paint.style = if (isStroke) Paint.Style.STROKE else Paint.Style.FILL
            paint.strokeWidth = strokeWidth
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createSector(@ColorInt color: Int, startAngle: Float, sweepAngle: Float, isStroke: Boolean = false, strokeWidth: Float = 6f): Drawable {
        return ShapeDrawable(SectorShape(startAngle, sweepAngle)).apply {
            paint.color = color
            paint.style = if (isStroke) Paint.Style.STROKE else Paint.Style.FILL
            paint.strokeWidth = strokeWidth
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun createHeart(@ColorInt color: Int, isStroke: Boolean = false, strokeWidth: Float = 6f): Drawable {
        return ShapeDrawable(HeartShape()).apply {
            paint.color = color
            paint.style = if (isStroke) Paint.Style.STROKE else Paint.Style.FILL
            paint.strokeWidth = strokeWidth
            intrinsicWidth = 100
            intrinsicHeight = 100
        }
    }

    fun roundedRect(@ColorInt color: Int, radius: Float): Drawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = radius
            setColor(color)
        }
    }

    fun circle(@ColorInt color: Int): Drawable {
        return createShape(ShapeType.OVAL, color)
    }

    fun borderedRect(@ColorInt fillColor: Int, radius: Float, stroke: Int, @ColorInt strokeColor: Int): Drawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = radius
            setColor(fillColor)
            setStroke(stroke, strokeColor)
        }
    }

    fun selector(normal: Drawable, pressed: Drawable): StateListDrawable {
        return StateListDrawable().apply {
            addState(intArrayOf(android.R.attr.state_pressed), pressed)
            addState(intArrayOf(), normal)
        }
    }

    fun View.setDrawableBackground(drawable: Drawable) {
        background = drawable
    }

    fun View.setRoundedBackground(@ColorInt color: Int, radius: Float) {
        background = roundedRect(color, radius)
    }

    fun View.setCircleBackground(@ColorInt color: Int) {
        background = circle(color)
    }
} 
