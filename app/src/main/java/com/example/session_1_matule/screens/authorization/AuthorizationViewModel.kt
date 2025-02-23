package com.example.session_1_matule.screens.authorization

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class AuthorizationState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)

class AuthorizationViewModel : ViewModel() {
    private val _state = MutableLiveData(AuthorizationState())
    val state: LiveData<AuthorizationState> = _state

    fun onEmailChanged(email: String) {
        _state.value = _state.value?.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        _state.value = _state.value?.copy(password = password)
    }

    fun onPasswordVisibilityChanged() {
        _state.value = _state.value?.copy(
            isPasswordVisible = !(_state.value?.isPasswordVisible ?: false)
        )
    }
}