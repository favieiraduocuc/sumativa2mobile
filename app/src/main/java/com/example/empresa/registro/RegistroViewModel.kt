package com.example.empresa.registro

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.empresa.data.UserRepository
import com.example.empresa.model.Usuario

class RegistroViewModel : ViewModel() {
    var nombre by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var contrasena by mutableStateOf("")
        private set
    var aceptarTerminos by mutableStateOf(false)
        private set
    var registroError by mutableStateOf<String?>(null)
        private set

    fun onNombreChange(newValue: String) {
        nombre = newValue
        registroError = null
    }

    fun onEmailChange(newValue: String) {
        email = newValue
        registroError = null
    }

    fun onContrasenaChange(newValue: String) {
        contrasena = newValue
        registroError = null
    }

    fun onAceptarTerminosChange(newValue: Boolean) {
        aceptarTerminos = newValue
    }

    fun registrarUsuario(): Boolean {
        if (nombre.isBlank() || email.isBlank() || contrasena.isBlank()) {
            registroError = "Por favor, complete todos los campos."
            return false
        }
        if (!aceptarTerminos) {
            registroError = "Debe aceptar los términos y condiciones."
            return false
        }
        if (UserRepository.emailExiste(email)) {
            registroError = "El email ya está registrado."
            return false
        }

        val nuevoUsuario = Usuario(nombre, email, contrasena)
        UserRepository.agregarUsuario(nuevoUsuario)
        return true
    }
}