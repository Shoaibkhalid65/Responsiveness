package com.example.responsiveness.uiSamples

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Airlines
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.AdminPanelSettings
import androidx.compose.material.icons.outlined.Airlines
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.responsiveness.R
import com.example.responsiveness.ui.theme.BrownColor
import com.example.responsiveness.ui.theme.LightBlueColor
import com.example.responsiveness.ui.theme.LightPinkColor
import com.example.responsiveness.ui.theme.LightestBlueColor

@Preview(showSystemUi = true)
@Composable
fun FinTechUISample() {
    Scaffold(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        LightBlueColor,
                        LightPinkColor
                    )
                )
            )
            .fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                CurrencyPriceItem(
                    modifier = Modifier.weight(2f),
                    imageResourceId = R.drawable.usa_flag1,
                    currencyName = "USD",
                    price = "$150.56"
                )
                CurrencyPriceItem(
                    modifier = Modifier.weight(2f),
                    imageResourceId = R.drawable.china_flag,
                    currencyName = "CNY",
                    price = "\u00A5 246.63"
                )
                Box(
                    modifier = Modifier.weight(1f).background(Color.White, shape = CircleShape).aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add icon",
                        modifier = Modifier.size(36.dp),
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.weight(0.1f))

            }
        }
    }
}

@Composable
fun CurrencyPriceItem(
    modifier: Modifier = Modifier,
    @DrawableRes imageResourceId: Int,
    currencyName: String,
    price: String
) {
    Row(
        modifier = modifier
            .background(color = Color.White, shape = CircleShape)
            .padding(horizontal = 13.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Image(
            painter = painterResource(imageResourceId),
            contentDescription = "country flag",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.weight(2.5f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = currencyName,
                color = Color.Black,
                fontSize = 16.sp,
                letterSpacing = 0.5.sp
            )
            Text(
                text = price,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif
            )
        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 36.dp, bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = LightestBlueColor
            )
        ) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "profile icon",
                modifier = Modifier.size(28.dp)
            )
        }
        Text(
            text = "My Wallet",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(4.5f),
            textAlign = TextAlign.Center,
            letterSpacing = 1.sp
        )
        IconButton(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = LightestBlueColor
            )
        ) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "profile icon",
                modifier = Modifier.size(28.dp)
            )
        }

    }
}

@Composable
fun BottomBar() {
    var selectedIndex by remember { mutableStateOf(0) }
    val outlinedImageVectors = remember {
        listOf(
            Icons.Outlined.Home,
            Icons.Outlined.AccountBalance,
            Icons.Outlined.Airlines,
            Icons.Outlined.AdminPanelSettings
        )
    }
    val filledImageVectors = remember {
        listOf(
            Icons.Default.Home,
            Icons.Default.AccountBalance,
            Icons.Default.Airlines,
            Icons.Default.AdminPanelSettings
        )
    }
    Row(
        modifier = Modifier
            .padding(vertical = 24.dp, horizontal = 36.dp)
            .background(color = Color.White, shape = CircleShape)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        outlinedImageVectors.forEachIndexed { index, vector ->
            val selected = selectedIndex == index
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = if (selected) BrownColor else Color.Transparent
                ),
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            ) {
                Icon(
                    imageVector = if (selected) filledImageVectors[index] else vector,
                    contentDescription = vector.name,
                    modifier = Modifier.size(30.dp),
                    tint = if (selected) Color.White else Color.Black
                )
            }
        }
    }
}