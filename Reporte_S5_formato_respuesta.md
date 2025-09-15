# Formato de respuesta — Semana 5 (DSY2204)

**Nombre estudiante:** Fabián Ignacio Vieira Villarroel  
**Asignatura:** Desarrollo de Aplicaciones Móviles (DSY2204)  
**Carrera:** Ingeniería en Desarrollo de Software  
**Profesor:** MIGUEL EMILIO PUEBLA CUERO
**Fecha:** 15-09-25

## Descripción de la actividad
Integrar en la app Android (accesibilidad visual) funcionalidades Kotlin: **funciones de orden superior, lambdas, funciones de extensión y manejo de excepciones**; entregar **ZIP del código** y **documentación en PDF**.  

## Información del proyecto
- **Organización:** DUOC UC  
- **Sección:** 002-A 
- **Proyecto SUMATIVA 2
- **Fecha de inicio/término:** 14-09-25 - 15-09-25  
- **Patrocinador/Docente:** MIGUEL EMILIO PUEBLA CUERO

## Alcance del proyecto
- **Problema:** KOTLIN Y ARQUITECTURA IMPLEMENTADA
- **Solución propuesta y contexto:** IMPLEMENTAR ARQUITECTURA BASADA EN KOTLIN

## Funciones esperadas (mockup)
- (Adjunte capturas de Login, Registro, Recuperar contraseña)

## Rendimiento esperado — Descripción de cada view
- **Login:** (navegación, validaciones, feedback)
- **Registro:** (reglas de contraseña, duplicidad de email)
- **Recuperar contraseña:** (flujo y mensajes)

## Restricciones del proyecto
- Adaptativa a múltiples dispositivos, conexión a internet (según guía).

## EDT — Diagrama y diccionario
- (Adjuntar imagen del diagrama)
- (Definir diccionario EDT: entregables y tareas)

## Resumen de riesgos (≥5)
| Riesgo | Fase | Probabilidad | Impacto | Mitigación |
|---|---|---|---|---|
| Accesibilidad insuficiente | Diseño | Media | Alto | Test con TalkBack, contraste |
| Errores de validación | Desarrollo | Media | Significativo | Unit tests y validaciones |
| Rendimiento en dispositivos gama baja | Pruebas | Baja | Moderado | Perf. profiling, lazy UI |
| Pérdida de datos | Operación | Baja | Alto | Backups, persistencia |
| Retraso en plazos | Gestión | Media | Significativo | EDT realista, hitos |

## Definición de artefactos
| Artefacto | Descripción |
|---|---|
| Código Android | Carpeta `app/` |
| Informe PDF | Este documento exportado |
| Mockups/Capturas | Flujo UI |
| Diagrama EDT | PNG/SVG |

## Condiciones de aceptación
- App compila/ejecuta.
- Cumple lambdas, HOF, extensiones, try/catch.
- Últimos 5 usuarios registrados visibles en repositorio.

## Anexos
- Capturas, diagrama EDT, enlaces al repo Git.
