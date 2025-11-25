package com.example.responsiveness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.responsiveness.curtainTransition.TransitionScreen
import com.example.responsiveness.uiSamples.BusinessUIDesign1Screen
import com.example.responsiveness.uiSamples.BusinessUIDesignScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TransitionScreen()
        }
    }
}

