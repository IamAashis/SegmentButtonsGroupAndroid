package com.android.segmentbuttongroupandroid

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Guideline
import androidx.core.content.ContextCompat
import androidx.transition.TransitionManager


class MainActivity : AppCompatActivity() {

    lateinit var motionLayout: MotionLayout
    lateinit var guideline: Guideline
    lateinit var leftText: TextView
    lateinit var rightText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        motionLayout = findViewById(R.id.mltMotionLayout)
        val button = findViewById<View>(R.id.button)
        guideline = findViewById(R.id.guideline_start)
        leftText = findViewById(R.id.txvBuyForOther)
        rightText = findViewById(R.id.txvBuyForMe)


        val blackColor = ContextCompat.getColor(this@MainActivity, R.color.black)
        val whiteColor = ContextCompat.getColor(this@MainActivity, R.color.white)

        motionLayout.addTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout, startId: Int, endId: Int) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                val guidelinePosition = guideline.x
                val buttonPosition = button.x
                val buttonWidth = button.width

                val buttonRightPosition = buttonPosition + buttonWidth

                val isAlignedToLeft = buttonPosition <= guidelinePosition
                val isAlignedToRight = buttonRightPosition >= guidelinePosition

                if (isAlignedToRight) {
                    Toast.makeText(this@MainActivity, "right", Toast.LENGTH_SHORT).show()
                    leftText.setTextColor(blackColor)
                    rightText.setTextColor(whiteColor)
                    // Add your logic here
                } else if (isAlignedToLeft) {
                    Toast.makeText(this@MainActivity, "left", Toast.LENGTH_SHORT).show()
                    leftText.setTextColor(whiteColor)
                    rightText.setTextColor(blackColor)
                    // Add your logic here
                }
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
                // Transition triggered
            }
        })


    }

}