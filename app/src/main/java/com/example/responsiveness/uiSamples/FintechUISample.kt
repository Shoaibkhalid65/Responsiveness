package com.example.responsiveness.uiSamples

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Airlines
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Start
import androidx.compose.material.icons.filled.Transform
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.responsiveness.ui.theme.GreenTextColor
import com.example.responsiveness.ui.theme.LightBlueColor
import com.example.responsiveness.ui.theme.LightPinkColor
import com.example.responsiveness.ui.theme.LightestBlueColor
import com.example.responsiveness.ui.theme.RedTextColor
import kotlin.math.abs

@Preview(showSystemUi = true, name = "Width:392.dp,Height:850.dp")
@Preview(
    device = "spec:width=360dp,height=800dp,dpi=360",
    showSystemUi = true,
    name = "Width:360.dp,Height:800.dp"
)
@Composable
fun FinTechUISample() {
    val actionItems = remember {
        listOf(
            ActionItem(imageVector = Icons.Default.Add, text = "Add"),
            ActionItem(imageVector = Icons.AutoMirrored.Default.Send, text = "Send"),
            ActionItem(imageVector = Icons.Default.Start, text = "Convert"),
            ActionItem(imageVector = Icons.Default.MoreHoriz, text = "More"),
        )
    }
    val transactions = remember {
        listOf(
            Transaction(
                id = 1,
                leadingIcon = Icons.Default.Start,
                title = "Conservation",
                time = "16:35 PM",
                amounts = listOf(1014.902f, -140.00f)
            ),
            Transaction(
                id = 2,
                leadingIcon = Icons.Default.Transform,
                title = "Transfer",
                time = "15:20 PM",
                amounts = listOf(-253.62f)
            ),
            Transaction(
                id = 3,
                leadingIcon = Icons.Default.Add,
                title = "Balance top-up",
                time = "14:16 PM",
                amounts = listOf(100.00f)
            ),
        )
    }
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
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
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
                    modifier = Modifier
                        .weight(0.9f)
                        .background(Color.White, shape = CircleShape)
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add icon",
                        modifier = Modifier.size(36.dp),
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.weight(0.1f))
            }
            Text(
                text = "Balance",
                color = BrownColor.copy(0.6f),
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 24.dp, bottom = 6.dp)
            )
            Text(
                text = "$150.56",
                color = BrownColor,
                fontSize = 42.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(36.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var selectedIndex by remember { mutableIntStateOf(0) }
                actionItems.forEachIndexed { index, item ->
                    val isSelected = selectedIndex == index
                    ActionItem(
                        imageVector = item.imageVector,
                        text = item.text,
                        isSelected = isSelected
                    ) {
                        selectedIndex = index
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Transactions",
                    color = BrownColor,
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    letterSpacing = 0.5.sp
                )
                OutlinedButton(
                    onClick = {},
                ) {
                    Text(
                        text = "View all",
                        color = BrownColor,
                        fontSize = 13.sp
                    )
                }
            }
            LazyColumn(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(transactions, key = { it.id }) { transaction ->
                    TransactionItem(transaction)
                }
            }


        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Row(
        modifier = Modifier
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = transaction.leadingIcon,
            contentDescription = transaction.leadingIcon.name,
            modifier = Modifier.padding(start = 4.dp, end = 16.dp).size(24.dp),
            tint = Color.Black,
        )
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)

            ) {
                Text(
                    text = transaction.title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 17.sp,
                    color = BrownColor
                )
                Text(
                    text = transaction.time,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = BrownColor.copy(0.7f)
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(4.dp), horizontalAlignment = Alignment.End) {
                transaction.amounts.forEach { amount ->
                    val color = if (amount > 0) GreenTextColor else RedTextColor
                    Text(
                        text = "${if (amount > 0) "+" else "-"} $${abs(amount)}",
                        color = color,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                    )

                }
            }
        }
    }
}


@Composable
fun RowScope.ActionItem(
    imageVector: ImageVector,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val contentColor = if (isSelected) Color.White else Color.Black
    val containerColor = if (isSelected) BrownColor else Color.White
    Column(
        modifier = Modifier
            .weight(1f)
            .aspectRatio(1f)
            .background(color = containerColor, shape = RoundedCornerShape(24.dp))
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = imageVector.name,
            tint = contentColor
        )
        Text(
            text = text,
            modifier = Modifier.padding(top = 1.dp),
            fontSize = 14.sp,
            color = contentColor
        )
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
            modifier = Modifier.weight(3.5f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = currencyName,
                color = Color.Black,
                fontSize = 15.sp,
                letterSpacing = 0.5.sp,
                maxLines = 1
            )
            Text(
                text = price,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                maxLines = 1
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
    var selectedIndex by remember { mutableIntStateOf(0) }
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
                onClick = {
                    selectedIndex = index
                },
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

data class ActionItem(val imageVector: ImageVector, val text: String)
data class Transaction(
    val id: Int,
    val leadingIcon: ImageVector,
    val title: String,
    val time: String,
    val amounts: List<Float>
)