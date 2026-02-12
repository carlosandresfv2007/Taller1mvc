# Taller 1 - Micro API REST: Registro de Estudiantes

API RESTful para registro y consulta de estudiantes, desarrollada con Java 25 y Spring Boot 3.

## Tecnología

- Java 17
- Spring Boot 3
- Gradle

## Ejecución
```bash
mvn clean install
mvn spring-boot:run
```

Servidor disponible en: `http://localhost:8080`

## Endpoints

- `POST /estudiantes` → Registra un estudiante (201 Created)
- `GET /estudiantes` → Lista todos los estudiantes (200 OK)

## Estrategia de Git — GitFlow

Se eligió **GitFlow** porque quiero profundizar mas en esta metodologia, y en este proyecto donde los modulos estan tan claros, controller, service y model, me parecio muy facil de integrar.

## Pipeline CI/CD — GitHub Actions

El archivo `.github/workflows/ci.yml` ejecuta dos jobs:

1. **build**: Se dispara en cualquier push o PR. Configura Java 25, instala dependencias y compila el proyecto con `mvn clean install`.
2. **release**: Se dispara únicamente cuando hay un push exitoso a `main`. Empaqueta el proyecto y crea automáticamente un GitHub Release con el `.jar` generado.