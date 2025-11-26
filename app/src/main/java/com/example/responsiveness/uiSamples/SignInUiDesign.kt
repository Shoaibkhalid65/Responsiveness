package com.example.responsiveness.uiSamples

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Anchor
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.SubdirectoryArrowRight
import androidx.compose.material.icons.outlined.Person4
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(device = "spec:width=360dp,height=800dp,dpi=320", showSystemUi = true)
@Preview(showSystemUi = true)
@Composable
fun SignInUIDesignScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            OutlinedIconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Person4,
                    contentDescription = "Profile",
                    tint = Color.Black
                )
            }
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                fontSize = 17.sp,
                fontFamily = FontFamily.Serif
            )
        }
        Text(
            text = "Sign In",
            fontFamily = FontFamily.Cursive,
            color = Color.Black,
            fontSize = 48.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(36.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
        Card(
            modifier = Modifier
                .weight(1f)
                .background(
                    Color.Black,
                    shape = RoundedCornerShape(topEnd = 36.dp, topStart = 36.dp)
                )
                .padding(24.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Email",
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    textAlign = TextAlign.Center
                )
                var email by remember { mutableStateOf("") }
                TextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.DarkGray,
                        focusedContainerColor = Color.DarkGray,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    shape = RoundedCornerShape(36.dp),
                    label = {
                        Text(
                            text = "Email",
                            color = Color.White,
                            fontSize = 15.sp,
                        )
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Password",
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    textAlign = TextAlign.Center
                )
                val state = rememberTextFieldState()
                SecureTextField(
                    state = state,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.DarkGray,
                        focusedContainerColor = Color.DarkGray,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    shape = RoundedCornerShape(36.dp),
                    label = {
                        Text(
                            text = "Password",
                            color = Color.White,
                            fontSize = 15.sp,
                        )
                    }
                )
                Spacer(modifier = Modifier.size(36.dp))
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color.Cyan,
                                Color.Magenta,
                                Color.Yellow,
                                Color.Red
                            )
                        )
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.SubdirectoryArrowRight,
                        contentDescription = "arrow",
                        tint = Color.DarkGray
                    )
                    Text(
                        text = "Sign In",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1.3f))
                Text(
                    text = "or Sign In with",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(24.dp),
                    color = Color.DarkGray
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    listOf(
                        Icons.Default.AccountBox, Icons.Default.AddComment, Icons.Default.Anchor,
                        Icons.Default.AlternateEmail
                    ).forEachIndexed { index, vector ->
                        ActionButton(vector)
                        if (index != 3) Spacer(modifier = Modifier.width(16.dp))
                    }
                }
                Spacer(modifier = Modifier.weight(1f))


            }
        }

    }
}

@Composable
fun ActionButton(imageVector: ImageVector) {
    IconButton(
        onClick = {},
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.DarkGray
        ),
        modifier = Modifier.size(62.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "action button",
            tint = Color.White,
            modifier = Modifier.size(36.dp)
        )
    }
}