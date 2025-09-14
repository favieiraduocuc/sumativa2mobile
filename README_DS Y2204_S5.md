# DSY2204 - Semana 5: Integrando Kotlin en Android (Empresa)

Este proyecto ya incluye:
- **Login, Registro y Recuperar Contraseña** en Jetpack Compose.
- **Funciones de orden superior**, **lambdas**, **funciones de extensión** y **manejo de errores** en `util/`.
- **Repositorio en memoria** (`UserRepository`) con **lista de últimos 5 usuarios registrados**.

## Cómo ejecutar
1. Abre el proyecto en **Android Studio Iguana o superior**.
2. Verifica `app/build.gradle.kts` tiene Compose habilitado.
3. Ejecuta en un **emulador Android** o **dispositivo físico**.

## Dónde mirar
- `data/UserRepository.kt`: cola de últimos 5 usuarios + HOFs.
- `util/Extensions.kt`: extensiones (propiedad `emailDomain`, `isStrongPassword`).
- `util/KotlinFunctions.kt`: HOFs (`filtrarUsuarios`, `compose`).
- `util/ErrorHandling.kt`: `parseEnteroSeguro` con `try/catch`.

## Checklist de entrega
- [ ] Repo Git remoto (GitHub/GitLab) compartido.
- [ ] ZIP del proyecto completo (esta carpeta `/app` y archivos raíz de Gradle).
- [ ] Informe **PDF** siguiendo el formato (ver `Reporte_S5_formato_respuesta.md`).