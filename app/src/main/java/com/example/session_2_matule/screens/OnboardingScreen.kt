package com.example.weather.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.session_2_matule.ui.theme.Block
import com.example.session_2_matule.ui.theme.Disable
import com.example.session_2_matule.ui.theme.SubTextLight
import com.example.session_2_matule.ui.theme.fontFamily
import com.example.session_2_matule.utils.AppIcons
import com.example.session_2_matule.utils.StringResources
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

/**
 * Data class representing a single onboarding page
 */
data class OnboardingPage(
    val topText: String = "",
    val showTopText: Boolean = false,
    val image: @Composable () -> Painter,
    val title: String,
    val description: String = "",
    val buttonText: String
)

/**
 * Screen showing onboarding content to first-time users
 */
@Composable
fun OnboardingScreen(
    onFinish: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pages = listOf(
        OnboardingPage(
            topText = StringResources.ONBOARDING_WELCOME,
            showTopText = true,
            image = { AppIcons.BackgroundBlueWhiteNike() },
            title = "",
            buttonText = StringResources.ONBOARDING_START
        ),
        OnboardingPage(
            image = { AppIcons.OrangeNike() },
            title = StringResources.ONBOARDING_PAGE1_TITLE,
            description = StringResources.ONBOARDING_PAGE1_DESCRIPTION,
            buttonText = StringResources.ONBOARDING_NEXT
        ),
        OnboardingPage(
            image = { AppIcons.PurpleNike() },
            title = StringResources.ONBOARDING_PAGE2_TITLE,
            description = StringResources.ONBOARDING_PAGE2_DESCRIPTION,
            buttonText = StringResources.ONBOARDING_NEXT
        )
    )

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF48B2E7),
                            Color(0xFF44A9DC),
                            Color(0xFF2B6B8B)
                        )
                    )
                )
                .padding(paddingValues)
        ) {
            HorizontalPager(
                count = pages.size,
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { position ->
                OnboardingPageContent(
                    page = pages[position],
                    currentPage = pagerState.currentPage,
                    pageCount = pages.size,
                    onNextClick = {
                        if (position < pages.size - 1) {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(position + 1)
                            }
                        } else {
                            onFinish()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun OnboardingPageContent(
    page: OnboardingPage,
    currentPage: Int,
    pageCount: Int,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(29.dp))

        // Welcome text animation
        AnimatedVisibility(
            visible = page.showTopText,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text(
                text = page.topText,
                fontSize = 30.sp,
                lineHeight = 30.sp,
                fontFamily = fontFamily,
                color = Block,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        // Spacing based on content
        if (page.showTopText) {
            Spacer(modifier = Modifier.height(108.dp))
        } else {
            Spacer(modifier = Modifier.height(37.dp))
        }

        // Main image
        Image(
            painter = page.image(),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )

        // Content section
        if (!page.showTopText) {
            Spacer(modifier = Modifier.height(60.dp))

            Column(
                modifier = Modifier.padding(horizontal = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = page.title,
                    fontSize = 34.sp,
                    lineHeight = 44.sp,
                    color = Block,
                    textAlign = TextAlign.Center,
                    fontFamily = fontFamily
                )

                if (page.description.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = page.description,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = SubTextLight,
                        fontFamily = fontFamily,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(if (page.showTopText) 26.dp else 40.dp))

        // Page indicators
        PageIndicators(
            currentPage = currentPage,
            pageCount = pageCount
        )

        Spacer(modifier = Modifier.weight(1f))

        // Navigation button
        Button(
            onClick = onNextClick,
            modifier = Modifier
                .padding(bottom = 36.dp)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Block
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = page.buttonText,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = com.example.session_2_matule.ui.theme.Text
                )
            )
        }
    }
}

@Composable
private fun PageIndicators(
    currentPage: Int,
    pageCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .width(if (index == currentPage) 43.dp else 28.dp)
                    .height(5.dp)
                    .background(
                        if (index == currentPage) Block else Disable,
                        RoundedCornerShape(5.dp)
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewOnboardingScreen() {
    OnboardingScreen(onFinish = {})
}