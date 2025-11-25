package com.example.responsiveness.uiSamples

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.outlined.TrendingUp
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.responsiveness.R
import com.example.responsiveness.ui.theme.AtlasColor1
import com.example.responsiveness.ui.theme.AtlasColor2
import com.example.responsiveness.ui.theme.AtlasColor3
import com.example.responsiveness.ui.theme.BlackBarColor
import com.example.responsiveness.ui.theme.PinkBarColor


//@Preview(showSystemUi = true)
//@Preview(device = "spec:width=360dp,height=800dp,dpi=320", showSystemUi = true)
@Composable
fun BusinessUIDesign1Screen() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        with(LocalDensity.current) {
            val maxWidth = this@BoxWithConstraints.maxWidth
            val maxHeight = this@BoxWithConstraints.maxHeight
            val horizontalPadding = if (maxWidth <= 365.dp) 18.dp else 24.dp
            val verticalPadding = if (maxHeight <= 800.dp) 30.dp else 36.dp
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                AtlasColor2,
                                AtlasColor1,
                                AtlasColor3
                            )
                        )
                    )
//                    .verticalScroll(state = rememberScrollState())
                    .padding(bottom = verticalPadding/2)
                ,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .padding(horizontal = horizontalPadding, vertical = verticalPadding / 2),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ActionButtonDesign(
                        modifier = Modifier.weight(1f),
                        imageVector = Icons.Default.Menu
                    )
                    Spacer(modifier = Modifier.weight(2.5f))
                    ActionButtonDesign(
                        modifier = Modifier.weight(1f),
                        imageVector = Icons.Outlined.Person
                    )
                    ActionButtonDesign(
                        modifier = Modifier.weight(1f),
                        imageVector = Icons.Outlined.Search
                    )
                }
                Text(
                    text = "Global partners",
                    color = Color.Black,
                    modifier = Modifier.padding(
                        top = verticalPadding,
                        bottom = verticalPadding / 2,
                        start = horizontalPadding
                    ),
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Agency that build many amazing product \n to boost your business to next level.",
                    color = Color.Black,
                    modifier = Modifier.padding(
                        start = horizontalPadding,
                        bottom = verticalPadding
                    ),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 22.sp
                )
                BusinessItemsCard(
                    horizontalPadding = horizontalPadding,
                    topText = "Companies \nJoined us",
                    bottomText = buildAnnotatedString {
                        append("300")
                        withStyle(
                            style = SpanStyle(
                                baselineShift = BaselineShift.Superscript,
                                fontSize = 28.sp,
                                letterSpacing = 4.sp
                            )
                        ) {
                            append("+")
                        }
                    },
                ) { modifier ->
                    Box(
                        modifier = modifier
                            .width(120.dp)
                            .wrapContentHeight()
                            .background(Color.Transparent)
                    ) {
                        BoxImage(
                            alignment = Alignment.CenterEnd,
                            imageResourceId = R.drawable.female_1
                        )
                        BoxImage(alignment = Alignment.Center, imageResourceId = R.drawable.male_1)
                        BoxImage(
                            alignment = Alignment.CenterStart,
                            imageResourceId = R.drawable.female_2
                        )
                    }
                }
                BusinessItemsCard(
                    horizontalPadding = horizontalPadding,
                    topText = "Exclusive \nBudget 55,000",
                    bottomText = "45M" as CharSequence
                ) { modifier ->
                    val array = floatArrayOf(7.5f, 9f, 4.5f, 6.5f, 3f, 8f, 6f, 10f, 3.5f, 10f)
                    Row(
                        modifier = modifier
                            .padding(10.dp)
                            .wrapContentSize(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        array.forEachIndexed { index, value ->
                            Box(
                                modifier = Modifier
                                    .width(10.dp)
                                    .height(value.times(3.6).dp)
                                    .background(
                                        color = if (index % 2 == 0) PinkBarColor else BlackBarColor,
                                        shape = CircleShape
                                    )
                            )
                        }
                    }
                }

                BusinessItemsCard(
                    horizontalPadding=horizontalPadding,
                    topText = "Inventing the future \nof design",
                    bottomText = "2.5x"
                ) {modifier ->
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.TrendingUp,
                        contentDescription = "Trending Up",
                        modifier = modifier
                            .padding(10.dp)
                            .size(48.dp),
                        tint = BlackBarColor
                    )
                }
            }
        }
    }
}

@Composable
fun BoxScope.BoxImage(alignment: Alignment, @DrawableRes imageResourceId: Int) {
    Box(
        modifier = Modifier.size(50.dp).background(color = Color.White, shape = CircleShape).align(alignment),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(imageResourceId),
            contentDescription = "female 2 photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(color = Color.Transparent)
                .size(45.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun ActionButtonDesign(modifier: Modifier = Modifier, imageVector: ImageVector) {
    FilledIconButton(
        onClick = {},
        modifier = modifier.aspectRatio(1f),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = imageVector.name
        )
    }
}

@Composable
fun BusinessItemsCard(
    horizontalPadding: Dp,
    topText: String,
    bottomText: CharSequence,
    content: @Composable (modifier: Modifier) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .aspectRatio(5 / 2.8f)
            .background(color = Color.White.copy(0.4f), shape = RoundedCornerShape(18.dp))
            .padding(
                start = horizontalPadding,
                end = horizontalPadding / 3,
                top = horizontalPadding / 3,
                bottom = horizontalPadding
            )
    ) {
        Text(
            text = topText,
            lineHeight = 20.sp,
            fontSize = 17.sp,
            color = Color.Black,
            fontWeight = FontWeight.W400,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .align(alignment = Alignment.TopStart)
        )
        Box(
            modifier = Modifier
                .size(72.dp)
                .background(color = Color.White, shape = CircleShape)
                .align(alignment = Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowOutward,
                contentDescription = "forward arrow icon",
                modifier = Modifier.align(alignment = Alignment.Center)
            )
        }
        Text(
            text = bottomText as? AnnotatedString ?: AnnotatedString(bottomText.toString()),
            lineHeight = 18.sp,
            color = Color.Black,
            fontSize = 58.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.align(alignment = Alignment.BottomStart)
        )
        content(Modifier.align(alignment = Alignment.BottomEnd))
    }
}

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
