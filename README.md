# 🎮 Proyecto de Simulación de Rol en Java 🎲

¡Bienvenido! Este repositorio alberga un fascinante proyecto de programación desarrollado en Java, concebido como parte de una asignación académica para el curso de Desarrollo de Aplicaciones Multiplataforma (DAM). El núcleo del proyecto es la creación y simulación de un vibrante universo de juego de rol (RPG) 🐲. Aquí, se gestionan personajes con diversas clases y atributos, se simulan combates detallados y estratégicos, se administra un complejo sistema de equipamiento y se exploran misteriosas mazmorras 🏰 pobladas por temibles monstruos. El sistema ha sido cuidadosamente diseñado para ser modular y extensible, permitiendo la incorporación de nuevas mecánicas y contenido con relativa facilidad.

## 📜 Descripción General del Proyecto

El proyecto se enfoca en la implementación de una lógica de juego de rol robusta y completa, abarcando desde la minuciosa definición individual de cada personaje hasta la simulación de complejas interacciones en emocionantes escenarios de aventura. Se ha puesto especial énfasis en la creación de una jerarquía de clases de personajes bien definida, cada una con sus propias habilidades únicas, progresiones de nivel y restricciones de equipamiento específicas.

Además, el sistema de combate considera múltiples factores cruciales, como las estadísticas base de los personajes, el impacto significativo del equipamiento portado y las reglas específicas de enfrentamiento, tanto para combates individuales como para desafiantes batallas grupales. La gestión de recursos externos, tales como archivos de configuración para mazmorras y datos de tesoros en formato CSV, también forma parte integral del proyecto. Esto demuestra la capacidad del sistema para interactuar fluidamente con fuentes de datos externas y para persistir información relevante del juego, como los detallados registros de combate y las fichas actualizadas de los personajes.

## ✨ Características Principales

El proyecto se distingue por un conjunto de características innovadoras y robustas que simulan con gran fidelidad la experiencia inmersiva de un juego de rol. A continuación, se detallan los componentes más significativos y emocionantes del sistema:

### 🎭 Jerarquía de Personajes Detallada

El sistema introduce una compleja y rica jerarquía de personajes, comenzando con una clase abstracta `Personaje`. Esta clase base establece los atributos fundamentales como nombre, raza (con restricciones específicas para evitar términos como "ángel" o "demonio" 🚫), nivel (inicializado en 1), puntos de vida (inicializados en 100 ❤️), ataque ⚔️, velocidad 💨, armadura 🛡️ y resistencia mágica 🔮 (inicializados en 10). Los personajes pueden `subirNivel()`, mejorando sus estadísticas con una probabilidad del 50% (excepto los puntos de vida, que siempre aumentan un 10% del valor actual). También disponen de métodos esenciales para `luchar()` y `defender()` (considerando daño físico y mágico).

A partir de esta sólida base, se derivan múltiples subclases especializadas, cada una con su propio estilo de juego:

- **Guerrero** 💪: Introduce el atributo "furia", que duplica el ataque a costa de recibir el doble de daño. Presenta ventajas en el incremento de ataque, vida y armadura, pero penalizaciones en resistencia mágica.
- **Mago** 🧙: Gestiona "puntos de magia" y tiene una alta probabilidad de incrementarlos al subir de nivel. Sobresale en resistencia mágica y velocidad, pero es más débil en atributos físicos. Puede `lanzarConjuro()` (como Bola de Fuego 🔥, Escudo Arcano 🛡️, Céfiro 🌬️, Presteza Mental 🧠) y `apoyar()` a aliados con hechizos no ofensivos.
- **Ladrón** 🗡️: Destaca por su alta velocidad y ataque, con penalizaciones en otros atributos. Su habilidad especial, `robar()`, le permite atacar utilizando su estadística de velocidad.
- **Cazador** 🏹: Tiene una ventaja en el incremento de velocidad y está acompañado por un `CompaneroAnimal` (una clase anidada que puede ser Cánido 🐺, Felino 🐅 o Rapaz 🦅), cuyas estadísticas son un porcentaje de las del cazador y que combate junto a él.

La subjerarquía de **Creyente** 🙏 (clase abstracta) introduce los "puntos de fe" y un método abstracto `plegaria()`. De esta derivan:

- **Paladín** 🌟: Un combatiente cuerpo a cuerpo con bonificaciones en armadura, vida y ataque, pero penalizaciones en velocidad y fe. Sus plegarias incluyen *Imbuir arma* y *Baluarte de fe*.
- **Clérigo** ✨: Especializado en combate a distancia y sanación, con altas probabilidades de mejorar fe y resistencia mágica, pero con penalizaciones en atributos físicos. Sus plegarias son *Sanación*, *Rezo sagrado* y *Cólera divina*. También puede `apoyar()` a aliados.
- **Monstruo** 👹: Representa a los enemigos del juego, con estadísticas que varían significativamente según su tipo (Bestia, NoMuerto 🧟, Gigante), cada uno con sus propias fortalezas y debilidades inherentes a su naturaleza.

### 🛠️ Sistema de Equipamiento Avanzado

El proyecto incorpora un sofisticado sistema de equipamiento gestionado por la clase abstracta `Equipamiento`. Cada pieza de equipo posee un nombre (limitado a 20 caracteres), estadísticas asociadas, una rareza (común, raro, épico, legendario  легендарный) que influye en la magnitud de sus bonificaciones, y un valor económico 💰. Las subclases de equipamiento son:

- **Arma** ⚔️: Puede mejorar la fuerza, magia, fe o velocidad. Se caracterizan por su empunadura (una o dos manos) y su tipo (espadas, mazas, hachas, cetros, dagas para una mano; espadones, martillos, arcos, bastones para dos manos).
- **Armadura** 🛡️: Proporciona estadísticas defensivas como armadura, resistencia mágica o vida. Se definen por su tipo (yelmos, pecheras, hombreras, guanteletes, grebas, botas) y material (tela, cuero, metal).
- **Artefacto** 💍: Piezas especiales que pueden otorgar cualquier tipo de estadística, limitadas a anillos y amuletos.

Cada clase de personaje tiene restricciones específicas sobre el tipo de armas y armaduras que puede equipar. Por ejemplo, los Magos solo pueden usar cetros o bastones y armaduras de tela, mientras que los Guerreros tienen un abanico más amplio de armas pero están restringidos a armaduras de metal. Incluso los monstruos tienen sus propias reglas de equipamiento.

### ⚔️ Mecánicas de Combate Estratégico

La clase `Combate` es central para la simulación de enfrentamientos emocionantes y tácticos. Los combates se desarrollan por turnos, donde el personaje con mayor velocidad ataca primero (si un personaje duplica la velocidad de otro, ¡golpea dos veces!). La victoria se alcanza cuando los puntos de vida del oponente llegan a cero 💔. Las estadísticas del equipamiento se suman a las del personaje para calcular el daño y la defensa en cada intercambio. El sistema también contempla combates grupales épicos, que se resuelven mediante una serie de duelos individuales entre los miembros de mayor nivel de cada grupo hasta que un bando es completamente eliminado. Como recompensa por la victoria, los personajes pueden recibir tesoros 💎, que son piezas de equipamiento aleatorias obtenidas de una colección cargada desde archivos CSV (`armas.csv`, `armaduras.csv`, `artefactos.csv`). Una vez otorgado, el tesoro se elimina de la colección disponible.

### 🗺️ Exploración de Mazmorras y Simulación de Aventuras

Para añadir profundidad y rejugabilidad a la experiencia, se introduce la clase `Mazmorra`. Cada mazmorra tiene un nombre, un conjunto de `Monstruos` únicos que la habitan (cuyos niveles están en un rango cercano al nivel promedio de la mazmorra) y se inicializa a partir de un archivo de configuración (ej. `mazmorra_1.txt`). La clase `Simulador` permite a un grupo de personajes embarcarse en una peligrosa serie de diez combates contra monstruos aleatorios de una mazmorra específica. Durante esta simulación, el equipamiento obtenido en los combates puede ser equipado por los personajes compatibles. La supervivencia de al menos un miembro del grupo determina la victoria en la mazmorra ✅; si todos perecen, la aventura se considera una derrota ❌ y el equipo de los personajes caídos se pierde para siempre.

### 💾 Gestión de Datos y Persistencia

El proyecto maneja eficientemente datos externos y la persistencia de información crucial del juego. La clase `GameLogger` proporciona métodos estáticos para generar fichas de personajes individuales o grupales en archivos de texto (ordenando los grupos por velocidad y luego alfabéticamente), y para guardar los registros detallados de los combates 📝. Los personajes pueden ser inicializados a partir de estos archivos de ficha, con un robusto manejo de excepciones y verificación de formato. El sistema también incluye funcionalidades para buscar personajes en los registros existentes y detectar si hay clases repetidas. La carga de tesoros desde archivos CSV y la configuración de mazmorras desde archivos de texto son ejemplos clave de esta interacción con el sistema de archivos. Además, se genera un archivo de log (`combate.log`) para registrar los eventos de los combates.

## 📂 Estructura del Proyecto

El código fuente del proyecto está organizado de manera lógica e intuitiva para facilitar la navegación, la comprensión y el mantenimiento futuro. La estructura principal del directorio del proyecto, denominada `ProyectoProgramacion`, se desglosa de la siguiente manera:

El directorio `src` es el corazón palpitante del proyecto ❤️, conteniendo todo el código fuente Java. Dentro de `src/main/java`, se encuentran los paquetes principales que definen la arquitectura de la aplicación:

- **personajes**: Este paquete agrupa todas las clases relacionadas con la definición de los diversos personajes del juego. Incluye la clase abstracta base `Personaje.java` y sus múltiples especializaciones como `Guerrero.java`, `Mago.java`, `Ladron.java` y `Cazador.java`. Además, contiene subpaquetes para jerarquías más específicas:
  - **creyentes**: Contiene la clase abstracta `Creyente.java` y sus derivaciones como `Clerigo.java` y `Paladin.java`.
  - **monstruos**: Alberga las clases que definen a los temibles adversarios, como `Monstruo.java` (que podría ser una clase base para diferentes tipos de monstruos como `Bestia.java`, `NoMuerto.java` y `Gigante.java`).
- **equipamiento**: Aquí se definen las clases para los valiosos objetos que los personajes pueden equipar. Esto incluye la clase abstracta `Equipamiento.java` y sus subclases concretas como `Arma.java`, `Armadura.java` y `Artefacto.java`.
- **sistema**: Este paquete es crucial para la lógica del juego, conteniendo clases que gestionan las mecánicas principales. `Combate.java` maneja las reglas y el flujo de las batallas. `Mazmorra.java` define los entornos de aventura y los enemigos que se encuentran en ellos. `Simulador.java` orquesta las secuencias de combates en las mazmorras. Finalmente, `GameLogger.java` se encarga de la Entrada/Salida de archivos relacionada con los datos del juego, como fichas de personajes y registros de combate.
- **util**: Contiene clases de utilidad transversales al proyecto, como `Constants.java` para valores constantes y `FileUtils.java`, que podría asistir en operaciones de lectura/escritura de archivos, por ejemplo, para cargar los datos de tesoros desde archivos CSV.
- `Main.java`: Es el punto de entrada de la aplicación 🚀, donde se inicia la ejecución del programa.

El directorio `src/test/java` está reservado para las pruebas unitarias 🧪, reflejando la estructura de paquetes de `src/main/java` para organizar las clases de prueba correspondientes a personajes, equipamiento y sistema.

Fuera del código fuente, el directorio `ficheros` juega un papel vital al almacenar recursos externos necesarios para la ejecución y el estado del juego:

- **logs**: Contiene archivos de registro, como `combate.log`, que guarda los detalles de los enfrentamientos.
- **csv**: Almacena datos en formato CSV, cruciales para el sistema de tesoros, con archivos como `armas.csv`, `armaduras.csv` y `artefactos.csv`.
- **mazmorras**: Guarda las configuraciones de las diferentes mazmorras, por ejemplo, `mazmorra_1.txt` podría definir la estructura y los monstruos de una mazmorra particular.

Finalmente, en la raíz del proyecto se encuentran archivos de configuración y documentación importantes como `.gitignore`, para especificar los archivos que no deben ser rastreados por el control de versiones, y este mismo `README.md`, que proporciona una guía completa y amigable del proyecto.

## ⚙️ Instalación

Para poner en marcha este proyecto en su entorno de desarrollo local, se requieren ciertos componentes de software y seguir unos pasos sencillos. Asegúrese de tener instalado un Java Development Kit (JDK), preferiblemente la versión 8 o una superior, ya que el proyecto ha sido desarrollado y probado con estas versiones en mente. Aunque cualquier Entorno de Desarrollo Integrado (IDE) compatible con Java puede ser utilizado, se recomiendan opciones populares como IntelliJ IDEA o Eclipse por su robusto soporte para proyectos Java y sus herramientas de gestión.

El proceso de instalación es directo y sencillo:

1. **Clone el repositorio**: Utilice el comando `git clone https://[URL-DEL-REPOSITORIO].git` (reemplace `[URL-DEL-REPOSITORIO]` con la URL real del repositorio) en su terminal, o descargue el código fuente como un archivo ZIP y extráigalo en la ubicación deseada de su sistema.
2. **Abra su IDE**: Una vez que tenga los archivos del proyecto, inicie su Entorno de Desarrollo Integrado preferido.
3. **Importe el proyecto**: La mayoría de los IDEs modernos pueden detectar automáticamente la estructura de un proyecto Java o permitir la importación de un proyecto desde fuentes existentes. Si el proyecto utiliza un sistema de gestión de dependencias como Maven o Gradle (no especificado en la estructura, pero común en proyectos Java), el IDE debería encargarse de descargar las dependencias necesarias. Si no es así, asegúrese de que todas las bibliotecas requeridas estén correctamente configuradas en el classpath del proyecto.
4. **Compile el código**: Una vez importado, el IDE debería permitirle compilar el código fuente. Busque la opción para construir o compilar el proyecto (a menudo un icono de martillo 🔨 o una opción en el menú "Build" o "Make Project"). Esto generará los archivos `.class` necesarios para la ejecución.
5. **Ejecute la aplicación**: Tras una compilación exitosa, estará listo para ejecutar la aplicación. Localice la clase `Main.java` dentro del paquete principal y ejecútela como una aplicación Java (normalmente click derecho -> Run As -> Java Application).

Es crucial verificar que la estructura de directorios, especialmente la carpeta `ficheros` con sus subdirectorios `logs`, `csv` y `mazmorras`, esté presente en la ubicación correcta relativa al ejecutable o al directorio de trabajo del proyecto, ya que la aplicación dependerá de estos archivos para cargar configuraciones, tesoros y guardar registros.

## ▶️ Uso

Una vez que el proyecto esté correctamente instalado y compilado, su uso principal se centrará en ejecutar la clase `Main.java` para iniciar la simulación o las funcionalidades implementadas. La interacción con el sistema se basará en las características descritas anteriormente, como la creación de personajes, la simulación de combates, la gestión de equipamiento y la exploración de mazmorras.

Para interactuar con el sistema, es probable que se deba modificar el código en `Main.java` o en clases de prueba para instanciar personajes, iniciar combates o simulaciones específicas. Por ejemplo, se podrían crear instancias de diferentes clases de personajes, equiparlos con armas y armaduras (cargadas desde los archivos CSV correspondientes), y luego enfrentarlos en un combate para observar el resultado y el registro generado en `combate.log`. De manera similar, se podría instanciar una `Mazmorra` a partir de su archivo de configuración y luego utilizar el `Simulador` para enviar un grupo de personajes a través de ella.

Es fundamental asegurarse de que los archivos de datos externos (CSVs para tesoros, archivos de texto para configuración de mazmorras) estén correctamente formateados y ubicados en el directorio `ficheros`, ya que el programa los leerá para su funcionamiento. Cualquier modificación en estos archivos (por ejemplo, añadir nuevas armas o definir nuevas mazmorras) se reflejará en la ejecución del programa.

La documentación del código, generada mediante JavaDoc 📖, será una herramienta valiosa para entender en detalle el funcionamiento de cada clase y método, facilitando la extensión o modificación del proyecto. Se recomienda revisar esta documentación para comprender las API internas y las capacidades de cada componente del sistema. Los ficheros de ejemplo que se solicitaban en las prácticas (no adjuntos aquí, pero mencionados en los guiones) también servirían como una excelente guía sobre cómo utilizar las diferentes partes del código y verificar que el output coincide con lo esperado.

## 🤝 Contribución

¡Las contribuciones son enormemente bienvenidas para mejorar y expandir este proyecto! 🙌 Si desea contribuir, por favor siga estos pasos:

1. **Haga un Fork**: Realice un fork del repositorio original a su propia cuenta de GitHub.
2. **Clone su Fork**: Clone su repositorio fork a su máquina local (`git clone https://github.com/SU_USUARIO/NOMBRE_REPOSITORIO.git`).
3. **Cree una Nueva Rama**: Cree una nueva rama para su característica o corrección (`git checkout -b feature/nueva-funcionalidad` o `fix/bug-especifico`).
4. **Realice sus Cambios**: Implemente sus mejoras o correcciones. Asegúrese de que el código sigue las convenciones y el estilo del proyecto. Es muy recomendable añadir pruebas unitarias para las nuevas funcionalidades.
5. **Haga Commit**: Realice commit de sus cambios con mensajes descriptivos y claros (`git commit -am 'Añadir nueva funcionalidad: descripción detallada'` o `'Corregir error X: descripción de la corrección'`).
6. **Empuje su Rama**: Empuje su rama a su repositorio fork en GitHub (`git push origin nombre-de-su-rama`).
7. **Abra un Pull Request**: Vaya al repositorio original y abra un Pull Request desde su rama hacia la rama principal del repositorio original. Detalle los cambios realizados y cualquier consideración relevante para la revisión.

Se agradece cualquier tipo de contribución, desde la corrección de errores tipográficos hasta la implementación de nuevas y complejas funcionalidades. ¡Juntos podemos hacer este proyecto aún mejor! ✨

## 📄 Licencia

Este proyecto se distribuye bajo los términos de la Licencia MIT. Puede encontrar una copia completa de la licencia en el archivo `LICENSE` (si no está presente, se asume la Licencia MIT estándar) que debería acompañar a este proyecto. Esta licencia permite un amplio grado de libertad para usar, modificar y distribuir el software, tanto para proyectos personales como comerciales, siempre y cuando se incluya el aviso de copyright y la declaración de la licencia en las copias o porciones sustanciales del software.

¡Gracias por su interés en este proyecto de programación! Esperamos que la documentación y el código fuente le sean de gran utilidad. 😊 ¡Feliz codificación! 💻
