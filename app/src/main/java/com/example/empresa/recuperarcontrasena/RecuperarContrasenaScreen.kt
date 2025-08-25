package com.example.empresa.ui.recuperarcontrasena

// Eliminamos 'import android.view.accessibility.AccessibilityManager'
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
import androidx.compose.ui.platform.LocalView // ¡NUEVA IMPORTACIÓN!
// Eliminamos 'import androidx.compose.ui.platform.LocalAccessibilityManager'
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun RecuperarContrasenaScreen(
    navController: NavController,
    viewModel: RecuperarContrasenaViewModel = viewModel()
) {
    // **CORRECCIÓN AQUÍ**: Obtenemos la View actual para llamar a announceForAccessibility.
    val view = LocalView.current
    val coroutineScope = rememberCoroutineScope() // Para lanzar corrutinas para anuncios

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Recuperar Contraseña",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Text(
            text = "Ingresa tu email para restablecer tu contraseña.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(bottom = 16.dp)
                // **MEJORA DE ACCESIBILIDAD**: Aseguramos que la instrucción sea leída claramente.
                .semantics { contentDescription = "Ingresa tu dirección de correo electrónico para restablecer tu contraseña." }
        )
        OutlinedTextField(
            value = viewModel.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Muestra el mensaje del ViewModel (éxito o error)
        if (viewModel.mensaje.isNotEmpty()) {
            Text(
                text = viewModel.mensaje,
                color = if (viewModel.mensaje.contains("encontrado")) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    // **MEJORA DE ACCESIBILIDAD**: Marca esta región como "viva" para que TalkBack la anuncie
                    // Usamos Assertive porque puede contener errores o confirmaciones importantes
                    .semantics { liveRegion = LiveRegionMode.Assertive }
            )
        }

        Button(
            onClick = {
                viewModel.enviarInstrucciones()
                // **MEJORA DE ACCESIBILIDAD**: Anunciamos la acción para que TalkBack la lea
                coroutineScope.launch {
                    view.announceForAccessibility("Se ha intentado enviar las instrucciones de recuperación.")
                    // El mensaje de éxito o error específico será anunciado por el liveRegion del Text de arriba
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                // **MEJORA DE ACCESIBILIDAD**: Añade una descripción de contenido clara para el botón
                .semantics { contentDescription = "Botón para enviar instrucciones de recuperación de contraseña" }
        ) {
            Text("Enviar")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                // **MEJORA DE ACCESIBILIDAD**: Añade una descripción de contenido clara
                .semantics { contentDescription = "Botón para cancelar y volver a la pantalla anterior" }
        ) {
            Text("Cancelar")
        }
    }
}