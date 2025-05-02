# Proyecto de Programación 1º DAM

## Descripción
Este proyecto consiste en la implementación de un sistema de personajes para un juego de rol, desarrollado como parte del curso de Desarrollo de Aplicaciones Multiplataforma (DAM). Incluye la creación de diversas clases y subclases que representan diferentes tipos de personajes, así como la gestión de combates y registros de juego.

## Contenido

### Tema 5 - Práctica

1. **Clase Abstracta main.java.personajes.Personaje**
   - Atributos: nombre, raza, nivel, puntos de vida, ataque, velocidad, armadura, resistencia mágica.
   - Métodos: `subirNivel()`, `luchar()`, `defender(int, String)`, `toString()`.
   - Condiciones: nombre mínimo de cuatro caracteres, raza no puede ser "ángel" ni "demonio".

2. **Subclase main.java.personajes.Guerrero**
   - Atributo adicional: furia.
   - Probabilidades y mejoras específicas para ataque, vida, armadura, resistencia mágica y velocidad.
   - Métodos sobrescritos: `subirNivel()`, `luchar()`, `defender()`, `toString()`.

3. **Subclase main.java.personajes.Mago**
   - Atributo adicional: puntos de magia.
   - Probabilidades y mejoras específicas para vida, armadura, ataque, resistencia mágica y velocidad.
   - Métodos adicionales: `lanzarConjuro(int, String)`, `apoyar(int, String)`.
   - Métodos sobrescritos: `subirNivel()`, `luchar()`, `toString()`.

4. **Subclase Ladrón**
   - Probabilidades y mejoras específicas para velocidad, ataque, vida, armadura y resistencia mágica.
   - Método adicional: `robar()`.
   - Métodos sobrescritos: `subirNivel()`, `toString()`.

5. **Subclase main.java.personajes.Cazador**
   - Atributo adicional: Compañero Animal (clase anidada).
   - Probabilidades y mejoras específicas para velocidad.
   - Métodos sobrescritos: `subirNivel()`, `luchar()`, `toString()`.

6. **Subclase Abstracta main.java.personajes.creyentes.Creyente**
   - Atributo adicional: puntos de fe.
   - Método adicional: `plegaria(int, String)`.
   - Métodos sobrescritos: `toString()`.

7. **Subclase Paladín**
   - Probabilidades y mejoras específicas para armadura, vida, ataque, velocidad y fe.
   - Métodos adicionales: `plegaria(int, String)`.
   - Métodos sobrescritos: `subirNivel()`, `toString()`.

8. **Subclase Clérigo**
   - Probabilidades y mejoras específicas para fe, resistencia mágica, vida, armadura y ataque.
   - Métodos adicionales: `plegaria(int, String)`, `apoyar(int, String)`.
   - Métodos sobrescritos: `subirNivel()`, `luchar()`, `toString()`.

9. **Subclase main.java.personajes.monstruos.Monstruo**
   - Ventajas y desventajas específicas según el tipo de monstruo (Bestia, No-muerto, Gigante).
   - Métodos sobrescritos: `toString()`.

10. **Clase Final main.java.sistema.Combate**
    - Procedimiento de combate entre dos personajes.
    - Registro de cada turno y resultado final del combate.

### Tema 6 - Práctica

1. **Clase main.java.utils.GameLogger**
   - Métodos de clase para crear y trabajar con ficheros.
   - Método para emitir la ficha de un personaje como fichero de texto.

2. **Emisión de Fichas de Grupo**
   - Método para emitir fichas de un grupo de personajes en un fichero de texto.
   - Orden de fichas por estadística de velocidad y alfabéticamente en caso de empate.

3. **Constructor Sobrecargado**
   - Constructor para inicializar un personaje desde un fichero de ficha.
   - Tratamiento de excepciones y verificación del formato del fichero.

4. **Verificación de Estado**
   - Método para verificar y actualizar el estado de un personaje según su ficha.

5. **Búsqueda de main.java.personajes.Personaje**
   - Método para evaluar si un personaje específico existe en los registros del juego.

6. **Búsqueda de Clases Repetidas**
   - Método para evaluar si existen personajes con clases repetidas en los ficheros recibidos.

7. **Registro de main.java.sistema.Combate**
   - Método para almacenar el registro de un combate entre dos personajes en un fichero.

8. **Subida de Nivel**
   - Método para subir de nivel a un personaje si ha ganado un combate, basado en el registro del combate y el grupo de personajes.

## Requisitos
- Java Development Kit (JDK) 8 o superior.
- IDE recomendado: IntelliJ IDEA o Eclipse.

## Instalación
- Abre el proyecto en tu IDE preferido.
- Compila y ejecuta los archivos `.java`.

## Uso
- Implementa las clases y métodos descritos en las prácticas.
- Documenta el código utilizando el formato de JavaDoc.
- Asegúrate de que los ficheros de ejemplo coincidan con el output del código.

## Contribución
- Realiza un fork del repositorio.
- Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
- Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva característica'`).
- Empuja la rama (`git push origin feature/nueva-caracteristica`).
- Abre un Pull Request.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---

¡Gracias por contribuir a este proyecto de programación! 😊

---
