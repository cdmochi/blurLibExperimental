package s.pete.blurexample.widget.CornerView

import android.R
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.FrameLayout


class CornerView : FrameLayout {
    private val path: Path = Path()
    private var radius = 16f

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val rect = RectF()
        path.reset()
        rect[0f, 0f, w.toFloat()] = h.toFloat()
        path.addRoundRect(rect, radius, radius, Path.Direction.CW)
        path.close()
    }

    override fun dispatchDraw(canvas: Canvas) {
        val save: Int = canvas.save()
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }
}