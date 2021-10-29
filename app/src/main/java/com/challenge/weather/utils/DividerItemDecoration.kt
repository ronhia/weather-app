package com.challenge.weather.utils

import android.graphics.Canvas
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.challenge.weather.R
import com.challenge.weather.utils.extensions.orZero

class DividerItemDecoration(
    @DrawableRes
    val dividerDrawableId: Int = R.drawable.bg_line_divider,
    private val insetStart: Int = 0,
    private val insetEnd: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val start = insetStart - parent.paddingStart
        val end = parent.width - insetEnd - parent.paddingEnd
        val dividerDrawable = ContextCompat.getDrawable(parent.context, dividerDrawableId)

        for (position in 0 until parent.childCount) {
            val child = parent.getChildAt(position)
            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + (dividerDrawable?.intrinsicHeight.orZero())

            dividerDrawable?.apply {
                setBounds(start, top, end, bottom)
                draw(canvas)
            }
        }
    }

}