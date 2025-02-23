package com.example.session_2_matule.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.session_2_matule.ui.theme.Accent
import com.example.session_2_matule.ui.theme.Block
import com.example.session_2_matule.ui.theme.SubTextDark
import com.example.session_2_matule.utils.AppIcons

@Composable
fun BottomBar(
    selectedIcon: String = "",
    onHomeClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onCartClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(106.dp)
    ) {
        // Background with double shadow effect
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = AppIcons.BackgroundBNB(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        // Centered floating action button
        Box(
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.TopCenter)
                .background(Accent, CircleShape)
                .clip(CircleShape)
                .clickable(onClick = onCartClick),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = AppIcons.Bag(),
                contentDescription = "Cart",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Block)
            )
        }

        // Bottom navigation icons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 31.dp)
                .padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Home icon
            NavigationIcon(
                icon = AppIcons.Home(),
                contentDescription = "Home",
                isSelected = selectedIcon == "home",
                onClick = onHomeClick
            )

            // Favorite icon
            NavigationIcon(
                icon = AppIcons.HeartOutline(),
                contentDescription = "Favorites",
                isSelected = selectedIcon == "favorite",
                onClick = onFavoriteClick
            )

            // Spacer for centered FAB
            Spacer(modifier = Modifier.width(24.dp))

            // Notification icon
            NavigationIcon(
                icon = AppIcons.Notification(),
                contentDescription = "Notifications",
                isSelected = selectedIcon == "notification",
                onClick = onNotificationClick
            )

            // Profile icon
            NavigationIcon(
                icon = AppIcons.Profile(),
                contentDescription = "Profile",
                isSelected = selectedIcon == "profile",
                onClick = onProfileClick
            )
        }
    }
}

@Composable
private fun NavigationIcon(
    icon: Painter,
    contentDescription: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painter = icon,
        contentDescription = contentDescription,
        modifier = modifier
            .size(24.dp)
            .clickable(onClick = onClick),
        colorFilter = ColorFilter.tint(
            if (isSelected) Accent else SubTextDark
        )
    )
}