package com.example.session_2_matule.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.session_2_matule.components.BottomBar
import com.example.session_2_matule.components.ProductCard
import com.example.session_2_matule.ui.theme.*
import com.example.session_2_matule.utils.AppIcons
import com.example.session_2_matule.utils.StringResources

/**
 * Main screen of the application displaying featured products and categories
 */
@Composable
fun HomeScreen(
    onOutdoorClick: () -> Unit,
    onHomeClick: () -> Unit,
    onMenuClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onCartClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val categories = listOf(
        StringResources.CATEGORY_ALL,
        StringResources.CATEGORY_OUTDOOR,
        StringResources.CATEGORY_TENNIS,
        StringResources.CATEGORY_RUNNING
    )

    Scaffold(
        bottomBar = {
            BottomBar(
                onHomeClick = onHomeClick,
                onFavoriteClick = onFavoriteClick,
                onCartClick = onCartClick,
                onNotificationClick = onNotificationClick,
                onProfileClick = onProfileClick,
                selectedIcon = "home"
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Background)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Top bar section
            TopBar(
                onMenuClick = onMenuClick,
                onCartClick = onCartClick
            )

            Spacer(modifier = Modifier.height(21.dp))

            // Search section
            SearchSection()

            Spacer(modifier = Modifier.height(21.dp))

            // Categories section
            CategoriesSection(
                categories = categories,
                onCategoryClick = { category ->
                    if (category == StringResources.CATEGORY_OUTDOOR) onOutdoorClick()
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Popular products section
            PopularProductsSection(
                onViewAllClick = onFavoriteClick
            )

            Spacer(modifier = Modifier.height(29.dp))

            // Promotions section
            PromotionsSection()
        }
    }
}

@Composable
private fun TopBar(
    onMenuClick: () -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = AppIcons.Menu(),
            contentDescription = StringResources.MENU,
            modifier = Modifier
                .size(26.dp)
                .clickable(onClick = onMenuClick)
        )

        Text(
            text = StringResources.HOME_TITLE,
            color = Text,
            fontSize = 32.sp,
            fontFamily = fontFamily,
            lineHeight = 32.sp
        )

        Box(
            modifier = Modifier
                .size(44.dp)
                .background(Block, CircleShape)
                .clickable(onClick = onCartClick)
        ) {
            Image(
                painter = AppIcons.Bag(),
                contentDescription = StringResources.CART,
                colorFilter = ColorFilter.tint(Text),
                modifier = Modifier.align(Alignment.Center)
            )
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(Red, CircleShape)
                    .align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
private fun SearchSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .size(269.dp, 52.dp)
                .background(Block, RoundedCornerShape(14.dp))
                .clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = AppIcons.Search(),
                contentDescription = StringResources.SEARCH,
                colorFilter = ColorFilter.tint(Hint),
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = StringResources.SEARCH,
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = fontFamily,
                color = Hint
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Box(
            modifier = Modifier
                .size(52.dp)
                .background(Accent, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = AppIcons.Shuffle(),
                contentDescription = "Shuffle",
                colorFilter = ColorFilter.tint(Block)
            )
        }
    }
}

@Composable
private fun CategoriesSection(
    categories: List<String>,
    onCategoryClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(start = 20.dp)
    ) {
        Text(
            text = StringResources.CATEGORIES,
            fontFamily = fontFamily,
            color = Text,
            fontSize = 16.sp,
            lineHeight = 16.sp
        )

        Spacer(modifier = Modifier.height(19.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories.size) { index ->
                CategoryItem(
                    category = categories[index],
                    onClick = { onCategoryClick(categories[index]) }
                )
            }
        }
    }
}

@Composable
private fun CategoryItem(
    category: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(108.dp, 40.dp)
            .background(Block, RoundedCornerShape(8.dp))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category,
            fontSize = 12.sp,
            lineHeight = 12.sp,
            fontFamily = fontFamily,
            letterSpacing = 1.sp,
            color = Text
        )
    }
}

@Composable
private fun PopularProductsSection(
    onViewAllClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = StringResources.HOME_POPULAR,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = fontFamily,
                color = Text
            )
            Text(
                text = StringResources.VIEW_ALL,
                color = Accent,
                fontFamily = fontFamily,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                modifier = Modifier.clickable(onClick = onViewAllClick)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            ProductCard(
                rightIcon = {
                    Image(
                        painter = AppIcons.Plus(),
                        contentDescription = StringResources.ADD_TO_CART,
                        colorFilter = ColorFilter.tint(Block)
                    )
                }
            )
            ProductCard(
                rightIcon = {
                    Image(
                        painter = AppIcons.Cart(),
                        contentDescription = StringResources.ADD_TO_CART,
                        modifier = Modifier.size(12.dp),
                        colorFilter = ColorFilter.tint(Block)
                    )
                }
            )
        }
    }
}

@Composable
private fun PromotionsSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = StringResources.HOME_PROMOTIONS,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                fontFamily = fontFamily,
                color = Text
            )
            Text(
                text = StringResources.VIEW_ALL,
                color = Accent,
                fontFamily = fontFamily,
                fontSize = 12.sp,
                lineHeight = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = AppIcons.Sale(),
            contentDescription = StringResources.HOME_PROMOTIONS,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        onFavoriteClick = {},
        onOutdoorClick = {},
        onHomeClick = {},
        onCartClick = {},
        onNotificationClick = {},
        onProfileClick = {},
        onMenuClick = {},
    )
}