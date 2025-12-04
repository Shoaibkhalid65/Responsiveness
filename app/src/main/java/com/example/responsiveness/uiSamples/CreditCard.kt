package com.example.responsiveness.uiSamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.responsiveness.R

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Composable
fun CreditCardUiSample() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF654ea3),
                        Color(0xFFeaafc8)
                    )
                )
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(24.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.White.copy(0.12f),
                            Color.White.copy(0.18f),
                            Color.White.copy(0.24f)
                        )
                    ),
                    shape = RoundedCornerShape(22.dp)
                )
                .fillMaxWidth()
                .aspectRatio(5 / 3f)
                .padding(vertical = 20.dp, horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.chip),
                    contentDescription = "chip icon",
                    tint = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.weight(6f))
                Icon(
                    painter = painterResource(R.drawable.countless_ind),
                    contentDescription = "countless indicator icon",
                    tint = Color.White,
                    modifier = Modifier.weight(0.65f)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
                    .align(alignment = Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    text = "Credit Card number",
                    color = Color.White.copy(0.65f)
                )
                Text(
                    text = "5337 8622 4901 3294",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Medium
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
                    .align(alignment = Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RowItem(
                    title = "Name",
                    text = "Shoaib Khalid"
                )
                RowItem(
                    title = "Exp. Date",
                    text = "06/26"
                )
                Box(
                    modifier = Modifier.size(width = 50.dp, height = 30.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(color = Color.Red, shape = CircleShape)
                            .align(alignment = Alignment.CenterStart)
                    )
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(color = Color(0xFFF28C28), shape = CircleShape)
                            .align(alignment = Alignment.CenterEnd)
                    )
                }

            }

        }
    }
}

@Composable
fun RowScope.RowItem(title: String, text: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = title,
            color = Color.White.copy(0.65f)
        )

        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}