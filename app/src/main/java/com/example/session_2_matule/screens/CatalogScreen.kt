package com.example.session_2_matule.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.example.session_2_matule.components.ProductCard
import com.example.session_2_matule.ui.theme.*
import com.example.session_2_matule.utils.AppIcons
import com.example.session_2_matule.utils.StringResources

/**
 * Screen displaying the catalog of products in the Outdoor category
 */
@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    val categories = listOf(
        StringResources.CATEGORY_ALL,
        StringResources.CATEGORY_OUTDOOR,
        StringResources.CATEGORY_TENNIS,
        StringResources.CATEGORY_RUNNING
    )

    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Background)
                .padding(paddingValues)
        ) {
            // Top bar with back button and title
            TopBar(
                title = StringResources.CATALOG_TITLE,
                onBackClick = onBackClick,
                modifier = modifier
            )

            Spacer(modifier = modifier.height(16.dp))

            // Categories section
            CategoriesSection(
                categories = categories,
                modifier = modifier
            )

            Spacer(modifier = modifier.height(20.dp))

            // Products grid
            ProductsGrid(modifier = modifier)
        }
    }
}

@Composable
private fun TopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Box(
            modifier = modifier
                .align(Alignment.CenterStart)
                .size(44.dp)
                .background(Block, CircleShape)
                .clickable(onClick = onBackClick),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = AppIcons.ChevronLeft(),
                contentDescription = StringResources.BACK
            )
        }

        Text(
            text = title,
            color = Text,
            fontFamily = fontFamily,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            modifier = modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun CategoriesSection(
    categories: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
    ) {
        Text(
            text = StringResources.CATEGORIES,
            fontFamily = fontFamily,
            fontSize = 16.sp,
            color = Text,
            lineHeight = 16.sp
        )

        Spacer(modifier = modifier.height(19.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories.size) { index ->
                CategoryItem(
                    category = categories[index],
                    isSelected = categories[index] == StringResources.CATEGORY_OUTDOOR
                )
            }
        }
    }
}

@Composable
private fun CategoryItem(
    category: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(108.dp, 40.dp)
            .background(
                if (isSelected) Accent else Block,
                RoundedCornerShape(8.dp)
            )
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category,
            fontSize = 12.sp,
            lineHeight = 12.sp,
            fontFamily = fontFamily,
            letterSpacing = 1.sp,
            color = if (isSelected) Block else Text
        )
    }
}

@Composable
private fun ProductsGrid(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(8) {
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
                            contentDescription = StringResources.FAVORITES,
                            colorFilter = ColorFilter.tint(Red),
                            modifier = modifier.size(16.dp)
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CatalogScreenPreview() {
    CatalogScreen()
}