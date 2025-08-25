// app/src/main/java/com/example/empresa/MainActivity.kt
package com.example.empresa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.empresa.ui.login.LoginScreen
import com.example.empresa.ui.recuperarcontrasena.RecuperarContrasenaScreen
import com.example.empresa.ui.registro.RegistroScreen
import com.example.empresa.ui.theme.EmpresaTheme // Este es el nombre de tu tema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Usa el tema de tu aplicación.
            EmpresaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    // rememberNavController es el "cerebro" de la navegación
    val navController = rememberNavController()

    // NavHost es el contenedor de tus pantallas
    NavHost(navController = navController, startDestination = "login") {

        // Define la ruta a la pantalla de Login
        composable("login") {
            LoginScreen(navController = navController)
        }

        // Define la ruta a la pantalla de Registro
        composable("registro") {
            RegistroScreen(navController = navController)
        }

        // Define la ruta a la pantalla de Recuperar Contraseña
        composable("recuperarContrasena") {
            RecuperarContrasenaScreen(navController = navController)
        }
    }
}