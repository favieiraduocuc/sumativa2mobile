package com.example.empresa.ui.recuperarcontrasena

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.empresa.data.UserRepository

class RecuperarContrasenaViewModel : ViewModel() {
    var email by mutableStateOf("")
        private set
    var mensaje by mutableStateOf("")
        private set

    fun onEmailChange(newValue: String) {
        email = newValue
        mensaje = ""
    }

    fun enviarInstrucciones() {
        if (email.isBlank() || !UserRepository.emailExiste(email)) {
            mensaje = "Email no encontrado. Por favor, intente con otro."
        } else {
            mensaje = "Instrucciones de recuperación enviadas a su correo."
        }
    }
}