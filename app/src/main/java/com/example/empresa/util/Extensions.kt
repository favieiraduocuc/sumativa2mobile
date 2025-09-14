package com.example.empresa.util

import com.example.empresa.model.Usuario

// --- Extension property: devuelve el dominio de un email o null si no es válido
val String.emailDomain: String?
    get() = this.substringAfter('@', missingDelimiterValue = "").takeIf { it.contains('.') }

// --- Extension function: valida si una contraseña es fuerte (>=8, alfanumérica)
fun String.isStrongPassword(): Boolean =
    length >= 8 && any { it.isDigit() } && any { it.isLetter() }

// --- Extension function sobre listas de Usuario: buscar por email (case-insensitive)
fun List<Usuario>.findByEmailIgnoreCase(email: String): Usuario? =
    firstOrNull { it.email.equals(email, ignoreCase = true) }
