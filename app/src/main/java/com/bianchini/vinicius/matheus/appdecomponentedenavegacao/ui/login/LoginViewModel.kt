package com.bianchini.vinicius.matheus.appdecomponentedenavegacao.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bianchini.vinicius.matheus.appdecomponentedenavegacao.R

class LoginViewModel : ViewModel() {

    sealed class AuthenticationState {
        object Authenticated : AuthenticationState()
        object Unauthenticated : AuthenticationState()
        class InvalidAuthenticationState(val fiends: List<Pair<String, Int>>) :
            AuthenticationState()
    }

    val authenticationStageEvent = MutableLiveData<AuthenticationState>()

    init {
        authenticationStageEvent.value = AuthenticationState.Unauthenticated
    }

    fun authentication(username: String, password: String) {
        if (isValidForm(username, password)) {
            authenticationStageEvent.value = AuthenticationState.Authenticated
        }
    }

    private fun isValidForm(username: String, password: String): Boolean {
        val invalidFields = arrayListOf<Pair<String, Int>>()
        if (username.isEmpty())
            invalidFields.add(INPUT_USERNAME)
        if (password.isEmpty())
            invalidFields.add(INPUT_PASSWORD)

        if (invalidFields.isNotEmpty()) {
            authenticationStageEvent.value =
                AuthenticationState.InvalidAuthenticationState(invalidFields)
            return false
        }
        return true
    }

    companion object {
        val INPUT_USERNAME = "INPUT_USERNAME" to R.string.login_input_layout_error_invalid_username
        val INPUT_PASSWORD = "INPUT_PASSWORD" to R.string.login_input_layout_error_invalid_password
    }
}