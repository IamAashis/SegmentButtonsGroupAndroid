package com.android.segmentbuttongroupandroid

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.constraintlayout.motion.widget.MotionLayout

class CustomMotionLayout(context: Context, attrs: AttributeSet?) : MotionLayout(context, attrs) {

    override fun performClick(): Boolean {
        // Implement your click handling logic here
        // Return true if the click event is consumed, false otherwise
        return super.performClick()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Handle touch events here
        // You can call performClick() to handle click events
        // Return true if the touch event is consumed, false otherwise
        return super.onTouchEvent(event)
    }
}