package com.example.session_2_matule.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.session_2_matule.ui.theme.*
import com.example.session_2_matule.utils.AppIcons

@Composable
fun ProductCard(
    title: String = "Nike Air Max",
    label: String = "BEST SELLER",
    price: String = "₽752.00",
    modifier: Modifier = Modifier,
    rightIcon: @Composable () -> Unit,
    heartIcon: @Composable () -> Unit = {
        Image(
            painter = AppIcons.HeartOutline(),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Text),
            modifier = modifier.size(16.dp),
        )
    },
) {
    Box(
        modifier = modifier
            .size(160.dp, 182.dp)
            .background(
                color = Block,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 9.dp)
        ) {
            Image(
                painter = AppIcons.BlueNike(),
                contentDescription = null,
                modifier = modifier
                    .padding(top = 18.dp)
                    .height(70.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = modifier.height(12.dp))
            Text(
                text = label,
                fontFamily = fontFamily,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Accent
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = title,
                fontFamily = fontFamily,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = Hint
            )
            Spacer(modifier = modifier.height(4.dp))
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(start = 9.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = price,
                fontFamily = fontFamily,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                color = Text
            )
            Box(
                modifier = modifier
                    .size(34.dp)
                    .background(
                        color = Accent,
                        shape = RoundedCornerShape(topStart = 16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                rightIcon()
            }
        }
        Box(
            modifier = modifier
                .padding(9.dp)
                .size(28.dp)
                .background(
                    color = Background,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            heartIcon()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductCard() {
    ProductCard(
       rightIcon = {
           Image(
               painter = AppIcons.Plus(),
               contentDescription = null,
               colorFilter = ColorFilter.tint(Block),
           )
       }
    )
}