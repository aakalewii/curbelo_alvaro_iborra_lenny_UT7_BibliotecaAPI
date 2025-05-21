# curbelo_alvaro_iborra_lenny_UT7_BibliotecaAPI

## Descripción breve

API REST para la gestión de una biblioteca, desarrollada en Spring Boot. Permite crear, consultar, actualizar y eliminar libros y autores, así como buscar libros por diferentes criterios.

## Instrucciones para ejecutar la API

1. **Clona el repositorio:**


2. **Configura la base de datos:**
- Asegúrate de tener MySQL instalado y crea una base de datos llamada `biblioteca`.
- Modifica el archivo `src/main/resources/application.properties` con tu usuario y contraseña de MySQL si es necesario.

3. **Compila y ejecuta el proyecto:**

4. **Accede a la API:**
- La API estará disponible en: [http://localhost:8080/v1](http://localhost:8080/v1)

5. **Endpoints principales:**
- `/v1/autores` para gestionar autores.
- `/v1/libros` para gestionar libros.
- `/v1/libros/buscar` para buscar libros por título, año, etc.

Puedes probar la API usando Postman o cualquier cliente REST.