package com.example.empresa.ui.login

// Se eliminan estas importaciones, ya no son necesarias para esta implementación.
// import android.view.accessibility.AccessibilityManager
// import androidx.compose.ui.platform.LocalAccessibilityManager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView // ¡IMPORTANTE: Usamos LocalView ahora!
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.PasswordVisualTransformation // Importación necesaria
import androidx.compose.ui.text.input.VisualTransformation // Importación necesaria
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    // Obtenemos la View actual para llamar a announceForAccessibility.
    val view = LocalView.current
    val coroutineScope = rememberCoroutineScope() // Para lanzar corrutinas para anuncios de accesibilidad

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Iniciar Sesión", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))

        // Campo para el correo electrónico
        OutlinedTextField(
            value = viewModel.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Campo para la contraseña
        OutlinedTextField(
            value = viewModel.contrasena,
            onValueChange = { viewModel.onContrasenaChange(it) },
            label = { Text("Contraseña") },
            // **CAMBIO AQUÍ**: Añadimos visualTransformation para ocultar la contraseña
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Muestra el mensaje de error si existe
        if (viewModel.loginError != null) {
            Text(
                text = viewModel.loginError!!,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    // **MEJORA DE ACCESIBILIDAD**: Marca esta región como "viva" para que TalkBack la anuncie
                    .semantics { liveRegion = LiveRegionMode.Assertive }
            )
        }

        // Botón para iniciar sesión
        Button(
            onClick = {
                val exito = viewModel.login()
                if (exito) {
                    // **MEJORA DE ACCESIBILIDAD**: Anuncia el éxito del inicio de sesión antes de navegar
                    coroutineScope.launch {
                        view.announceForAccessibility("Inicio de sesión exitoso. Redirigiendo a la pantalla principal.")
                    }
                    // Aquí puedes navegar a otra pantalla, por ejemplo a la pantalla de inicio
                    // navController.navigate("home")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                // **MEJORA DE ACCESIBILIDAD**: Añade una descripción de contenido clara para el botón
                .semantics { contentDescription = "Botón para ingresar a la aplicación" }
        ) {
            Text("Ingresar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para ir a la pantalla de registro
        TextButton(
            onClick = { navController.navigate("registro") },
            modifier = Modifier
                .fillMaxWidth()
                // **MEJORA DE ACCESIBILIDAD**: Añade una descripción de contenido clara
                .semantics { contentDescription = "¿No tienes cuenta? Botón para registrarse" }
        ) {
            Text("¿No tienes cuenta? Regístrate")
        }

        // Botón para ir a la pantalla de recuperación de contraseña
        TextButton(
            onClick = { navController.navigate("recuperarContrasena") },
            modifier = Modifier
                .fillMaxWidth()
                // **MEJORA DE ACCESIBILIDAD**: Añade una descripción de contenido clara
                .semantics { contentDescription = "Botón para recuperar contraseña" }
        ) {
            Text("¿Olvidaste tu contraseña?")
        }
    }
}