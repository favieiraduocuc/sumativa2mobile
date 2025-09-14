package com.example.empresa.util

import com.example.empresa.model.Usuario

// Función de orden superior que recibe un "criterio" (lambda) para filtrar usuarios
fun filtrarUsuarios(usuarios: List<Usuario>, criterio: (Usuario) -> Boolean): List<Usuario> =
    usuarios.filter(criterio)

// Composición simple de funciones (otra forma de HOF)
fun <A,B,C> compose(f: (B) -> C, g: (A) -> B): (A) -> C = { a -> f(g(a)) }

// Ejemplo de referencia a función como valor
val contarCaracteres: (String) -> Int = String::length
