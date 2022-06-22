# TitaMedia 
## COMPONENTE TEÓRICO.
1) la ingeniería de Software en la encargada de implementar arquitecturas y procesos de desarrollo liderando dichos grupos de desarrollo. 
2) API REST: (REST) es un método de comunicación entre cliente y servido, y una de sus características es Api rest el cual funciona por método de GET, POST, PUT, DELETE
API SOAP: es un método de comunicación igual de cliente servidor, manejando archivos de comunicación xml, wsdll.
Diferencias: 1) Api Rest: se maneja por métodos y Soap por archivos. 2) velocidad y facilidad de implantación 3) la Seguridad.
La api REST es la mas utiliza, ya que este nos permite el envió de objetos JSON por medio de HTTP.  Y son mas rápidas de utilizar e implementan ioT, al igual las API SOAP. Son muy utilizadas en los sectores Bancarios por su nivel de seguridad. 
3) ORM es un paquete de controlador de conexión entre la base de datos y el proyecto y la manipulación e interacción.
ORM Conocidas: JDBC, JSP, MONGODB
Se utilizan para facilitar la conexión entre la base de datos y la app, ya que beneficia implementar menos código. 
4) Las interfaces son un intermediario entre la acción y la lógica.  
5) 510

## Tecnologias.
* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
*   [Angular](https://angular.io/guide/router-tutorial) - FrontEnd
* 	[Git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* 	[SQL](https://url/) - Base de Datos MariaDB
* 	[PrimeNg](https://url/) - libreria de estilos


## Tener Encuenta.

- Se utilizo una Base de datos MariaDb. Por favor Cambiar el Enrutamiento del servidor de Datos en el YML.(Actualizar las Url de enlase donde se ejecuto el Script Sql DB).
- Comandos y rutas nativas para banck y front. (No Cambia).

## Endpoint Creados.
 - http://localhost:8090/0.1/version
 - http://localhost:8090/0.1/auth
 
       {
            "userName":"titaMedia",  "jhd",  "otros", 
            "password":"123456", "654321", "123"
        }
                            
  -  http://localhost:8090/0.1/detalleUsuario
         (Params) ?id = usuario_id
  -  http://localhost:8090/0.1/RealizarPago
  
         {
             "bancoId":2,
             "usuarioId":3,
             "valorPagado":0,
             "fechaPago":"18/06/2022"
         }
                          
 -   http://localhost:8090/0.1/usuarios
