package com.example.session_2_matule.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.session_2_matule.components.ProductCard
import com.example.session_2_matule.ui.theme.*
import com.example.session_2_matule.utils.AppIcons
import com.example.session_2_matule.utils.StringResources

/**
 * Screen displaying user's favorite products
 */
@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onHeartClick: () -> Unit = {}
) {
    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Background)
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
        ) {
            // Top bar with navigation and actions
            TopBar(
                onBackClick = onBackClick,
                onHeartClick = onHeartClick,
                modifier = modifier
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Grid of favorite products
            ProductsGrid(modifier = modifier)
        }
    }
}

@Composable
private fun TopBar(
    onBackClick: () -> Unit,
    onHeartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Back button
        ActionButton(
            icon = AppIcons.ChevronLeft(),
            contentDescription = StringResources.BACK,
            onClick = onBackClick
        )

        // Title
        Text(
            text = StringResources.FAVORITE_TITLE,
            fontSize = 16.sp,
            fontFamily = fontFamily,
            color = Text,
            lineHeight = 24.sp
        )

        // Heart button
        ActionButton(
            icon = AppIcons.HeartOutline(),
            contentDescription = StringResources.FAVORITES,
            onClick = onHeartClick,
            iconSize = 24.dp
        )
    }
}

@Composable
private fun ActionButton(
    icon: Painter,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp
) {
    Box(
        modifier = modifier
            .size(44.dp)
            .background(Block, CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = icon,
            contentDescription = contentDescription,
            colorFilter = ColorFilter.tint(Text),
            modifier = Modifier.size(iconSize)
        )
    }
}

@Composable
private fun ProductsGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(7) {
            ProductCard(
                rightIcon = {
                    Image(
                        painter = AppIcons.Plus(),
                        contentDescription = StringResources.ADD_TO_CART,
                        colorFilter = ColorFilter.tint(Block)
                    )
                },
                heartIcon = {
                    Image(
                        painter = AppIcons.HeartFilled(),
                        contentDescription = StringResources.REMOVE_FROM_FAVORITES,
                        colorFilter = ColorFilter.tint(Red),
                        modifier = Modifier.size(16.dp)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFavoriteScreen() {
    FavoriteScreen()
}