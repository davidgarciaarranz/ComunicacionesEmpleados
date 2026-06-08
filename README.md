# Gestión de Incidencias con Spring WebClient

## Descripción

Este proyecto implementa un cliente HTTP utilizando Spring WebClient para consumir un servicio REST de gestión de empleados. La aplicación permite obtener información de empleados de forma síncrona y asíncrona, utilizando programación reactiva con Reactor.

Para realizar pruebas, se dispone de un conjunto de empleados de ejemplo.

## Funcionamiento

* Consulta de empleados mediante peticiones HTTP GET.
* Consumo de servicios REST utilizando WebClient.
* Obtención de datos de forma síncrona mediante bloqueo controlado.
* Obtención de datos de forma asíncrona utilizando programación reactiva.
* Configuración de tiempos de espera para evitar bloqueos indefinidos.
* Gestión de respuestas mediante objetos DTO.
* Simulación de empleados para pruebas de funcionamiento.
* Securización mediante autenticación HTTP Basic
* Control de acceso a todos los endpoints de la aplicación
* Gestión de usuarios y roles almacenados en memoria.
* Cifrado de contraseñas mediante PasswordEncoder.

## Estructura del proyecto

```text
src/
├── config/
│   └── SecurityConfigurationMode.javaa
├── controller/
│   └── EmpleadosController.java
├── dtos/
│   └── EmpleadosDto.java
├── repositoryHttpClient/
│   ├── EmpleadosRepository.java
│   └── EmpleadosRepositoryImpl.java
└── ...
```

### Componentes principales

* **EmpleadosDto**: Representa la información de una incidencia.
* **EmpleadosRepository**: Define las operaciones disponibles para acceder a las incidencias.
* **EmpleadosRepositoryImpl**: Implementa el acceso al servicio REST mediante WebClient.
* **Generador de empleados**: Proporciona datos de ejemplo para realizar pruebas.
* **SecurityConfigurationMode**: Archivo de configuración de seguridad básica de protección de los endpoints.

## Seguridad

La aplicación incorpora Spring Security para proteger el acceso a los servicios REST.

Se han definido dos usuarios en memoria:

| Usuario | Rol |
|----------|------|
| usuario | USER |
| administrador | USER, ADMIN |

Todas las peticiones requieren autenticación mediante HTTP Basic.
Las contraseñas se almacenan cifradas utilizando PasswordEncoder.

## Tecnologías utilizadas

* Java
* Spring Boot
* Spring WebFlux
* WebClient
* Reactor
* Programación reactiva
* HTTP REST APIs
* Spring Security
* HTTP Basic Authentication
* PasswordEncoder

## Autor

Desarrollado por David García