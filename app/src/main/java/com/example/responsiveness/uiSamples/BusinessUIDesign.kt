package com.example.responsiveness.uiSamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.responsiveness.ui.theme.AtlasColor1
import com.example.responsiveness.ui.theme.AtlasColor2
import com.example.responsiveness.ui.theme.AtlasColor3

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(device = "spec:width=360dp,height=800dp,dpi=320", showSystemUi = true)
//@Preview(showSystemUi = true)
@Composable
fun BusinessUIDesignScreen() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        with(LocalDensity.current) {
            val localConfiguration = LocalConfiguration.current
            val maxWidth = this@BoxWithConstraints.maxWidth
            val maxHeight = this@BoxWithConstraints.maxHeight
            val minWidth = minWidth
            val minHeight = minHeight
            val constraints = constraints
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                AtlasColor2,
                                AtlasColor1,
                                AtlasColor3,
                            )
                        )
                    ),
                containerColor = Color.Transparent
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 16.dp, vertical = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        ActionIconButton(imageVector = Icons.Default.Menu)
                        Spacer(modifier = Modifier.weight(1f))
                        ActionIconButton(imageVector = Icons.Outlined.Person)
                        ActionIconButton(imageVector = Icons.Default.Search)
                    }
                    Text(
                        text = "height $maxHeight width is $maxWidth minheight $minHeight minWidth $minWidth constraints ${constraints.maxWidth} ${constraints.maxHeight}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "density dpi ${localConfiguration.densityDpi} height ${localConfiguration.screenHeightDp} width ${localConfiguration.screenWidthDp} smallest widht ${localConfiguration.smallestScreenWidthDp}"
                    )


                }
            }
        }
    }
}


@Composable
fun ActionIconButton(imageVector: ImageVector) {
    BoxWithConstraints {
        val maxWidth = this.maxWidth
        val maxHeight = this.maxHeight

        IconButton(
            onClick = {},
            modifier = Modifier.size(54.dp),
            colors = IconButtonDefaults.iconButtonColors(
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
}


@Composable
fun ResponsiveBox() {
    BoxWithConstraints(content = {
        with(LocalDensity.current) {
            val rectangleHeight = 100.dp
            if (this@BoxWithConstraints.maxHeight < rectangleHeight * 2) {
                Box(Modifier
                    .size(50.dp, rectangleHeight)
                    .background(Color.Blue))
            } else {
                Column {
                    Box(Modifier
                        .size(50.dp, rectangleHeight)
                        .background(Color.Blue))
                    Box(Modifier
                        .size(50.dp, rectangleHeight)
                        .background(Color.Gray))
                }
            }
        }

    }
    )
}

@Preview(showSystemUi = true)
@Preview(device = "spec:width=360dp,height=800dp,dpi=320", showSystemUi = true)
@Composable
fun BusinessUiUsingWeight() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        AtlasColor2,
                        AtlasColor1,
                        AtlasColor3
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(vertical = 24.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier.weight(1f).aspectRatio(1f),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = Icons.Default.Menu.name
                )
            }
            Spacer(modifier = Modifier.weight(2.5f))
            IconButton(
                onClick = {},
                modifier = Modifier.weight(1f).aspectRatio(1f),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = Icons.Default.Menu.name
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier.weight(1f).aspectRatio(1f),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = Icons.Default.Menu.name
                )
            }


        }
    }
}



