package com.example.empresa.ui.registro

// Eliminamos 'import android.content.Context'
// Eliminamos 'import android.view.accessibility.AccessibilityManager'
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
import com.example.empresa.registro.RegistroViewModel // Asegúrate de que esta importación sea correcta
import kotlinx.coroutines.launch

@Composable
fun RegistroScreen(
    navController: NavController,
    viewModel: RegistroViewModel = viewModel()
) {
    // **CORRECCIÓN AQUÍ**: Obtenemos la View actual.
    // Usaremos esta View para llamar a announceForAccessibility.
    val view = LocalView.current
    val coroutineScope = rememberCoroutineScope() // Para lanzar corrutinas para anuncios

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Crear Cuenta",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = { viewModel.onNombreChange(it) },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = viewModel.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = viewModel.contrasena,
            onValueChange = { viewModel.onContrasenaChange(it) },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .semantics(mergeDescendants = true) {
                    contentDescription = "Casilla de verificación para aceptar los términos y condiciones"
                }
        ) {
            Checkbox(
                checked = viewModel.aceptarTerminos,
                onCheckedChange = { viewModel.onAceptarTerminosChange(it) }
            )
            Text(
                text = "Acepto los términos y condiciones",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        if (viewModel.registroError != null) {
            Text(
                text = viewModel.registroError!!,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .semantics { liveRegion = LiveRegionMode.Assertive }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                val exito = viewModel.registrarUsuario()
                if (exito) {
                    coroutineScope.launch {
                        // **CORRECCIÓN AQUÍ**: Llamamos a announceForAccessibility en la View.
                        view.announceForAccessibility("Registro exitoso. Volviendo a la pantalla de inicio de sesión.")
                    }
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Botón para registrar nueva cuenta" }
        ) {
            Text("Registrarse")
        }

        Spacer(modifier = Modifier.height(8.dp))
        TextButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Botón para volver a la pantalla de inicio de sesión" }
        ) {
            Text("Volver a Iniciar Sesión")
        }
    }
}