# Diccionario EDT — Proyecto Empresa (Semana 5)

**Fecha:** 2025-09-14

## 1. Preparación
- **1.1 Configurar Compose:** revisar `build.gradle.kts`, BOM, Activity Compose.
- **1.2 Navegación:** `NavHost` con Login/Registro/Recuperar.
- **1.3 Estructura paquetes:** `data/`, `util/`, `login/`, `registro/`, `recuperarcontrasena/`.
- **1.4 README:** pasos de ejecución y checklist.

## 2. Desarrollo Kotlin
- **2.1 Extensions.kt:** `emailDomain`, `isStrongPassword`, `findByEmailIgnoreCase`.
- **2.2 KotlinFunctions.kt:** `filtrarUsuarios`, `compose`, `contarCaracteres`.
- **2.3 ErrorHandling.kt:** `parseEnteroSeguro` (try/catch con `Result`).
- **2.4 UserRepository.kt:** cola de últimos 5 registrados + HOF/Extensiones en consultas.

## 3. UX/Accesibilidad
- **3.1 Contraste/labels:** textos descriptivos, `contentDescription`.
- **3.2 Validaciones accesibles:** mensajes claros, foco en errores.
- **3.3 Capturas:** evidencias de los 3 flujos.

## 4. Documentación
- **4.1 Reporte (PDF):** completar `Reporte_S5_formato_respuesta.md` y exportar.
- **4.2 Riesgos (≥5):** prob/impacto/mitigación.
- **4.3 Diccionario EDT:** este documento.
- **4.4 Anexos:** mockups, capturas, EDT.

## 5. QA/Pruebas
- **5.1 Manuales:** login, registro (duplicidad de email), recuperar contraseña.
- **5.2 Correcciones:** ajustar validaciones/UX.
- **5.3 Verificación:** contra guía y pauta.

## 6. Entrega
- **6.1 Git:** subir al remoto.
- **6.2 ZIP:** proyecto + PDF.
- **6.3 AVA:** enviar enlace al repo + archivo ZIP único.