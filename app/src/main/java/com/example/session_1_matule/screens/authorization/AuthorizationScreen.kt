package com.example.session_1_matule.screens.authorization

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.session_1_matule.ui.theme.*
import com.example.session_1_matule.utils.AppIcons
import com.example.session_1_matule.utils.StringResources

@Composable
fun AuthorizationScreen(
    viewModel: AuthorizationViewModel = viewModel(),
    onLoginClick: () -> Unit
) {
    val state by viewModel.state.observeAsState(AuthorizationState())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Block)
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(78.dp))

        Text(
            text = buildAnnotatedString {
                append(StringResources.HI)
                withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                    append(StringResources.GREETING_SUFFIX)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = AppTypography.h1.copy(),
            color = Text
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = StringResources.SOCIAL_MEDIA_PROMPT,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = AppTypography.body1.copy(),
            color = SubTextDark
        )

        Spacer(modifier = Modifier.height(35.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = StringResources.EMAIL_LABEL,
                style = AppTypography.body2.copy(),
                color = Text
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = state.email,
                onValueChange = viewModel::onEmailChanged,
                placeholder = {
                    Text(
                        text = StringResources.EMAIL_PLACEHOLDER,
                        style = AppTypography.subtitle1.copy(),
                        color = Hint
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Background,
                    unfocusedContainerColor = Background,
                    focusedBorderColor = Background,
                    unfocusedBorderColor = Background,
                ),
                textStyle = AppTypography.subtitle1.copy()
            )
        }

        Spacer(modifier = Modifier.height(26.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = StringResources.PASSWORD_LABEL,
                style = AppTypography.body2.copy(),
                color = Text
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = state.password,
                onValueChange = viewModel::onPasswordChanged,
                placeholder = {
                    Text(
                        text = StringResources.PASSWORD_PLACEHOLDER,
                        style = AppTypography.subtitle1.copy(),
                        color = Hint
                    )
                },
                singleLine = true,
                visualTransformation =
                if (state.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(
                        onClick = viewModel::onPasswordVisibilityChanged,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter =
                            if (state.isPasswordVisible) AppIcons.VisibilityOn() else AppIcons.VisibilityOff(),
                            contentDescription =
                            if (state.isPasswordVisible) "Hide password" else "Show password",
                            tint = Hint,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Background,
                    unfocusedContainerColor = Background,
                    focusedBorderColor = Background,
                    unfocusedBorderColor = Background,
                ),
                textStyle = AppTypography.subtitle1.copy()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextButton(
                    onClick = { },
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.height(16.dp)
                ) {
                    Text(
                        text = StringResources.RESTORE_PASSWORD,
                        style = AppTypography.caption.copy(),
                        color = SubTextDark
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Accent
                )
            } else {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = {
                        onLoginClick()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Accent
                    ),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = StringResources.LOGIN_BUTTON,
                        style = AppTypography.button.copy(),
                        color = Background
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = StringResources.FIRST_TIME_PROMPT,
                    style = AppTypography.body1.copy(),
                    color = Hint
                )

                Spacer(modifier = Modifier.width(4.dp))

                TextButton(
                    onClick = {},
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.height(16.dp)
                ) {
                    Text(
                        text = StringResources.CREATE_USER_PROMPT,
                        style = AppTypography.body1.copy(),
                        color = Text
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewAuthorizationScreen() {
    AuthorizationScreen(
        onLoginClick = {}
    )
} 