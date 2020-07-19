package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.withStyledAttributes
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R

class PrefixCustomEditText(context: Context, attrs: AttributeSet) :
    AppCompatEditText(context, attrs) {

    private var mPrefix = "+95"
    private var mPrefixColor = Color.BLACK

    private val mPrefixRect = Rect()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // 1. place the prefix text
        paint.getTextBounds(mPrefix, 0, mPrefix.length, mPrefixRect)

        // 2. add space
        mPrefixRect.right += paint.measureText(" ").toInt()

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {

        // set text color
        paint.color = mPrefixColor

        // 3. start draw
        canvas?.drawText(
            mPrefix,
            super.getCompoundPaddingLeft().toFloat(),
            baseline.toFloat(),
            paint
        )

        super.onDraw(canvas)
    }

    // 4. define start position to type text.
    override fun getCompoundPaddingLeft(): Int {
        return super.getCompoundPaddingLeft() + mPrefixRect.width()
    }


}