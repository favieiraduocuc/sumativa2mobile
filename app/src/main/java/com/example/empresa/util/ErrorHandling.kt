package com.example.empresa.util

// Demostración de try/catch con retorno de valor y mensaje seguro
fun parseEnteroSeguro(texto: String): Result<Int> = try {
    Result.success(texto.trim().toInt())
} catch (e: NumberFormatException) {
    Result.failure(e)
}
