package com.example.empresa.data

import com.example.empresa.model.Usuario

object UserRepository {
    private val usuarios = mutableListOf<Usuario>()

    fun agregarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun buscarUsuario(email: String, contrasena: String): Usuario? {
        return usuarios.find { it.email == email && it.contrasena == contrasena }
    }

    fun emailExiste(email: String): Boolean {
        return usuarios.any { it.email == email }
    }
}