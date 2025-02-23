package com.example.session_2_matule.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.session_2_matule.ui.theme.Accent
import com.example.session_2_matule.ui.theme.Block
import com.example.session_2_matule.utils.AppIcons
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Accent)
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            // Centered logo
            Box(
                modifier = Modifier
                    .size(129.dp)
                    .background(Block, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = AppIcons.Bag(),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(60.dp),
                    colorFilter = ColorFilter.tint(Accent)
                )
            }
        }

        // Auto-navigate after delay
        LaunchedEffect(Unit) {
            delay(1000)
            onNext()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSplashScreen() {
    SplashScreen(onNext = {})
}