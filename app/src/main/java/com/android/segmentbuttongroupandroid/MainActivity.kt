package com.android.segmentbuttongroupandroid

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.Guideline
import androidx.core.content.ContextCompat

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
                val isAlignedToRight = buttonRightPosition > guidelinePosition

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

        val startConstraintSet = motionLayout.getConstraintSet(R.id.start)
        val endConstraintSet = motionLayout.getConstraintSet(R.id.end)

        var isButtonOnLeft = true // Track the current position of the button


  /*      motionLayout.setOnTouchListener { _, event ->
            when (event.action) {
               *//* MotionEvent.ACTION_DOWN -> {
                    val touchX = event.rawX
                    val rightViewX = rightText.x
                    val leftViewX = leftText.x + leftText.width

                    if (isButtonOnLeft && touchX >= rightViewX) {
                        // Move the button from left to right
                        motionLayout.transitionToEnd()
                        isButtonOnLeft = false
                        true
                    } else if (!isButtonOnLeft && touchX < leftViewX) {
                        // Move the button from right to left
                        motionLayout.transitionToStart()
                        isButtonOnLeft = true
                        true
                    } else {
                        false
                    }
                }*//*
                MotionEvent.ACTION_UP -> {
                    motionLayout.performClick() // Call performClick() when the touch is released
                    true
                }
                else -> false
            }
        }*/






    }




}