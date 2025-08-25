package com.example.empresa.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.empresa.data.UserRepository

class LoginViewModel : ViewModel() {

    var email by mutableStateOf("")
        private set

    var contrasena by mutableStateOf("")
        private set

    var loginError by mutableStateOf<String?>(null)
        private set

    fun onEmailChange(newValue: String) {
        email = newValue
        loginError = null
    }

    fun onContrasenaChange(newValue: String) {
        contrasena = newValue
        loginError = null
    }

    fun login(): Boolean {
        if (email.isBlank() || contrasena.isBlank()) {
            loginError = "Por favor, complete todos los campos."
            return false
        }

        val usuarioEncontrado = UserRepository.buscarUsuario(email, contrasena)

        return if (usuarioEncontrado != null) {
            true
        } else {
            loginError = "Email o contraseña incorrectos."
            false
        }
    }
}