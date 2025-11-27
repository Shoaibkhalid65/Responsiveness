package com.example.responsiveness.uiSamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.responsiveness.ui.theme.AtlasColor1
import com.example.responsiveness.ui.theme.AtlasColor2
import com.example.responsiveness.ui.theme.AtlasColor3

@Preview(showSystemUi = true)
@Composable
fun AtlasWelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            // 1. Use the same gradient background for a seamless feel.
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        AtlasColor2,
                        AtlasColor1,
                        AtlasColor3
                    )
                )
            )
            .statusBarsPadding()
            // Add padding to keep content away from the edges
            .padding(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // A Spacer to push content down a bit
        Spacer(modifier = Modifier.weight(1f))
//
//        // 2. The main visual element: a subtle world map icon.
//        // It's large but has low alpha to not be distracting.
        Icon(
            imageVector = Icons.Default.Language, // You'll need to add this asset
            contentDescription = "World Map",
            modifier = Modifier.size(200.dp),
            tint = Color.White.copy(alpha = 0.3f)
        )
//
        Spacer(modifier = Modifier.height(24.dp))
//
//        // 3. A bold, welcoming title.
        Text(
            text = "Welcome to Atlas",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black
        )

        Text(
            text = "Your Global Business Dashboard",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black.copy(alpha = 0.8f)
        )
//
//        // Spacer to push the call-to-action to the bottom
        Spacer(modifier = Modifier.weight(1.5f))

        // 4. A clear call-to-action guiding the user to swipe.
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Swipe left",
                tint = Color.Black.copy(alpha = 0.6f)
            )
            Text(
                text = "Slide to explore",
                fontSize = 14.sp,
                color = Color.Black.copy(alpha = 0.6f)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}
