package com.example.empresa.data

import com.example.empresa.model.Usuario
import com.example.empresa.util.findByEmailIgnoreCase
import com.example.empresa.util.filtrarUsuarios

object UserRepository {
    private val lastFive: ArrayDeque<Usuario> = ArrayDeque()
    private val usuarios = mutableListOf<Usuario>()

    fun agregarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        // mantener un arreglo/cola de los últimos 5 registrados
        lastFive.addFirst(usuario)
        while (lastFive.size > 5) lastFive.removeLast()
    }

    // Exponer copia inmutable de los últimos 5 registrados
    fun ultimosCinco(): List<Usuario> = lastFive.toList()

    fun buscarUsuario(email: String, contrasena: String): Usuario? {
        val candidato = usuarios.findByEmailIgnoreCase(email)
        return candidato?.takeIf { it.contrasena == contrasena }
    }
    }

    fun emailExiste(email: String): Boolean {
        return filtrarUsuarios(usuarios) { it.email.equals(email, ignoreCase = true) }.isNotEmpty()
    }
    }
}