# Plataforma Solidaridad Escuela

## Período académico: 2021-2

## Nombre del curso: Ciclos de Vida del Desarrollo de Software - CVDS

## Nombre del profesor

+   Oscar David Ospina Rodriguez - Product Owner

## Integrantes

+   José Manuel Gamboa Gómez - Back
+   Zuly Valentina Vargas Ramírez - Front
+   Cristian Camilo Forero Monroy - UX
+   Camilo Andrés Pichimata Cárdenas - Back

### Reporte de análisis estético de código

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/f2bb6066ee2249488b34a41489893cf5)](https://www.codacy.com/gh/STECH-Group/2021-2-PROYCVDS-STECH-Group/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=STECH-Group/2021-2-PROYCVDS-STECH-Group&amp;utm_campaign=Badge_Grade)

### Enlace a la aplicación en Heroku

[![ProjectDesign](https://www.herokucdn.com/deploy/button.png)](https://solidaridadeci.herokuapp.com)

### Enlace al sistema de integración continua

[![CircleCI](https://circleci.com/gh/STECH-Group/2021-2-PROYCVDS-STECH-Group/tree/master.svg?style=svg)](https://circleci.com/gh/STECH-Group/2021-2-PROYCVDS-STECH-Group/tree/master)

## Descripción del producto

### Descripción General

La **Plataforma Solidaridad Escuela**, es una herramienta para generar un entorno de comunicación y ayuda dentro de la comunidad de la Escuela Colombiana de Ingeniería Julio Garavito. El sistema permite que los estudiantes puedan expresar las necesidades que puedan tener de algún elemento para poder desarrollar sus actividades de forma correcta, y que los demás miembros de la comunidad puedan facilitar estos elementos a quienes lo necesitan. De igual manera los miembros de la comunidad pueden ofrecer diferentes elementos que sean de interés para los estudiantes sin que exista alguna solicitud específica. Adicionalmente el sistema cuenta con diferentes funcionalidades de reportería y administración que permite llevar un control del funcionamiento de la plataforma y del alcance que se está logrando.

### Manual de Usuario

Al ingresar al enlace de la aplicación se muestra la pantalla de inicio. Al lado derecho de esta se encuentra la descripción del proyecto junto al botón que redirecciona al usuario para que pueda 
iniciar sesión. Al lado izquierdo se encuentran los enlaces directos al manual de usuario y a el campus virtual de la universidad. 

[![home-exp.jpg](https://i.postimg.cc/wxhppzqK/home-exp.jpg)](https://postimg.cc/w3TPXSRF)

Al dar en ingresar se muestra la pantalla de inicio de sesión, en esta se deben ingresar los datos correspondientes. Luego de ingresar los datos se da en ingresar para continuar al menu de usuario con las diferentes opciones. 

[![login-exp.jpg](https://i.postimg.cc/Kzx53tMD/login-exp.jpg)](https://postimg.cc/f3qd6t5V)

Los perfiles de usuario que maneja la plataforma de SOLIDARIDAD ECI son los siguientes:

+   Administrador
+   Administrativo
+   Estudiante
+   Egresado 
+   Profesor 

Según el rol del usuario, se muestran los principales servicios del sistema a las cuales puede acceder. Las principales funcionalidades de la plataforma y los usuarios autorizados para cada una son :

## Registro de Necesidad

**Roles autorizados:** Estudiante.

En el registro de necesidad los usuarios expresan las necesidades que presentan. Para acceder a este servicio debe dirigirse al menú principal, dar click en "Necesidad" y en la opción de "Registrar necesidad".

[![necesidad1-exp.jpg](https://i.postimg.cc/N0k9Wm2S/necesidad1-exp.jpg)](https://postimg.cc/PLN5DL4Q)

En la pantalla de Registro Necesidades se debe incluir la siguiente información necesaria. 
En primer lugar se debe agregar una **descripción** de la necesidad en el cuadro de texto extendible. 

[![necesidad-desc-exp.jpg](https://i.postimg.cc/W1srns3s/necesidad-desc-exp.jpg)](https://postimg.cc/ykrk64cG)

Seguido a esto se debe agregar el **nivel de urgencia** de la necesidad, donde 1 es el nivel más bajo y 5 el más alto.

[![necesidad-urg-exp.jpg](https://i.postimg.cc/Vvy0b8pQ/necesidad-urg-exp.jpg)](https://postimg.cc/wyVjSS90)

En **Estado** se debe indicar el estado de la necesidad donde se encuentran las opciones de: Activo, En Proceso, Resuelto y Cerrado. 

[![necesidad-estado-exp.jpg](https://i.postimg.cc/6QKTLc5g/necesidad-estado-exp.jpg)](https://postimg.cc/JsT1RbX5)

Por último se debe indicar la categoría a la cual pertenece la necesidad.

[![necesidad-estado-exp.jpg](https://i.postimg.cc/TPrzXqxV/necesidad-estado-exp.jpg)](https://postimg.cc/nshR4mCr)

Luego de ingresar la información necesaria se debe dar en el botón **Registrar** para ser redirigido a la consulta de necesidades para verificar que esta haya sido registrada. 

[![necesidad-reg-exp.jpg](https://i.postimg.cc/rpch5664/necesidad-reg-exp.jpg)](https://postimg.cc/hXybq5t4)

Luego de registrar, podemos observar como ha sido guardada la petición recien realizada.

[![necesidad-consulta-exp.jpg](https://i.postimg.cc/5ycp9Dmj/necesidad-consulta-exp.jpg)](https://postimg.cc/8JHLtK9V)

## Actualización Estado de necesidad

**Roles autorizados:** Administrador, Estudiante.

En la actualización del estado de una necesidad se cambia el estado actual de la necesidad deseada. Los estudiantes solo pueden cambiar el estado de las necesidades que registraron mientras que el administrador puede cambiar el estado de las necesidades registradas por los estudiantes. Para acceder a este servicio debe dirigirse al menú principal, dar click en "Necesidad" y en la opción de "Actualizar estado necesidad".

[![necesidad-act1-exp.jpg](https://i.postimg.cc/8PZWtqrW/necesidad-act1-exp.jpg)](https://postimg.cc/QHWHMYmx)

Al dar click en la opción, será redirigido a la ventana de actualización. En esta se debe seleccionar la necesidad que se desea actualizar y seleccionar el nuevo estado de esta.

[![necesidad-act2-exp.jpg](https://i.postimg.cc/W4L4nnSg/necesidad-act2-exp.jpg)](https://postimg.cc/874DkL2z)

Para actualizar la necesidad seleccionada se da click en el botón de "Actualizar". Seguido a esto se mostrará actualizada la necesidad con su última fecha de modificación correspondiente.

[![necesidad-act3-estado-exp.jpg](https://i.postimg.cc/TYB2d9zF/necesidad-act3-estado-exp.jpg)](https://postimg.cc/YhfB81qz)

## Dar respuesta a una necesidad

**Roles autorizados:** Administrador, Estudiante, Administrativo, Profesor y Egresado.

En el registro de respuesta a necesidad los usuarios pueden responder a las necesidades activas actualmente. Para esto se debe desplegar el menu en Necesidades y dar en la opción "Registrar respuesta a necesidad ".

[![registro-resp-nece.jpg](https://i.postimg.cc/sgFKjqst/registro-resp-nece.jpg)](https://postimg.cc/9rpy1x4p)

Al dar click será redireccionado a la pantalla selección de necesidad a dar respuesta. En esta se selecciona y se da click en "Responder" para continuar.

[![respuesta-nece-con.jpg](https://i.postimg.cc/wx4gGcgt/respuesta-nece-con.jpg)](https://postimg.cc/HjMqJMJH)

En la pantalla de registro se debe agregar un comentario de respuesta y dar click en el botón "Registrar" para que sea agregada.

[![respuesta-comentario.jpg](https://i.postimg.cc/5yKzHHhP/respuesta-comentario.jpg)](https://postimg.cc/BPDbkvQD)

## Registro de Oferta

**Roles autorizados:** Administrador, Estudiante, Administrativo, Profesor y Egresado.

En el registro de oferta los usuarios expresan los diferentes elementos que pueden brindar a la comunidad. Para acceder a este servicio debe dirigirse al menú principal, dar click en "Oferta" y en la opción de "Registrar oferta".

[![registro-oferta.jpg](https://i.postimg.cc/C18YndRF/registro-oferta.jpg)](https://postimg.cc/r0q7vVGb)

En la pantalla de Registro de Oferta se debe incluir la siguiente información necesaria. 
En primer lugar se debe agregar una **descripción** de la oferta en el cuadro de texto extendible. Al igual que en la necesidad agregamos el **estado** de la OFerta y el **nombre de la categoría** a la cual pertenece. 

[![registro-oferta-datos.jpg](https://i.postimg.cc/pVBH3mnF/registro-oferta-datos.jpg)](https://postimg.cc/hhh6dPsD)

Luego de registrar será redireccionado a la consulta de ofertas para verificar que haya sido registrada.

[![consulta-ofertas-usuario.jpg](https://i.postimg.cc/dt1GyT2R/consulta-ofertas-usuario.jpg)](https://postimg.cc/vDJ1RTSD)

Para actualizar la necesidad seleccionada se despliega el menu en Ofertas y se da click en el botón "Actualizar estado oferta". Seguido a esto se mostrará la lista de ofertas. El Administrador puede cambiar el estado de cualquier oferta, mientras que lo sdemás usuarios solo pueden editar el estado de sus ofertas registradas.

[![actualizar-oferta1.jpg](https://i.postimg.cc/htbXfDJW/actualizar-oferta1.jpg)](https://postimg.cc/CR5h2VHm)

Luego de dar en "Actualizar" se mostrará la respuesta con la actualización del estado.

[![actualizar-oferta2.jpg](https://i.postimg.cc/dQkjHxNk/actualizar-oferta2.jpg)](https://postimg.cc/G9RD9qCd)

## Dar respuesta a una Oferta

**Roles autorizados:** Administrador, Estudiante, Administrativo, Profesor y Egresado.

En el registro de respuesta a oferta los usuarios pueden responder a las ofertas activas actualmente. Para esto se debe desplegar el menu en Ofertas y dar en la opción "Registrar respuesta a oferta".
Se mostrarán las ofertas activas existentes, en esta pantalla se debe seleccionar la oferta que se quiere dar respuesta y dar en "Responder".

[![resp-oferta1.jpg](https://i.postimg.cc/DZBsmqzX/resp-oferta1.jpg)](https://postimg.cc/WFqtHqgN)

Al dar click será direccionado al registro de la respuesta, en este debe agregar un comentario y dar uevamente en "Registrar" para guardar la respuesta.

[![resp-oferta2.jpg](https://i.postimg.cc/pThCNGCd/resp-oferta2.jpg)](https://postimg.cc/62KnnhDs)

## Registro de categorías

**Roles autorizados:** Administrador.

Para la dministración de las categorias el usuario Administrador es el único autorizado. Para registrar se debe desplegar el menú en "Categorías" y dar click en "Registro de Categoría".

[![registro-categoria-menu.jpg](https://i.postimg.cc/3rSsMNTS/registro-categoria-menu.jpg)](https://postimg.cc/WtZWg2tg)

En la pantalla de registro el Administrador debe agregar el nombre de la nueva categoría, descripción y el estado de esta.

[![registro-categoria-datos.jpg](https://i.postimg.cc/wBmYqp6K/registro-categoria-datos.jpg)](https://postimg.cc/QBhymv9S)

## Actualización estado de categoría

**Roles autorizados:** Administrador.

En la actualización de categorías el administrador puede cambiar el nombre de la categoría, agregar una nueva descripción o cambiar el estado.

[![categoria-act-1.jpg](https://i.postimg.cc/Z5dFcbZD/categoria-act-1.jpg)](https://postimg.cc/JsRk7Wsb)

Luego de actualizar, se muestra la consulta de categorías donde se puede ver la categoría actualizada.

[![categoria-act-2.jpg](https://i.postimg.cc/TwjMzvxR/categoria-act-2.jpg)](https://postimg.cc/hzG5mwhw)

## Eliminación Categoría 

**Roles autorizados:** Administrador.

Para eliminar una categoría el administradir debe desplegar el menú para categoría y seleccionar la opción para eliminar.

[![eliminar-cat-menu.jpg](https://i.postimg.cc/9fv5rtVN/eliminar-cat-menu.jpg)](https://postimg.cc/rdCYH4DS)

Luego de seleccionar la opción será redigirido a la pantalla donde se muestran todas las categorías. En esta el Administrador debe seleccionar la categoría a eliminar y dar en "Eliminar". 

[![eliminar-cat-boton.jpg](https://i.postimg.cc/xCff03RD/eliminar-cat-boton.jpg)](https://postimg.cc/8FYQ4W9t)

## Reporte de servicios

**Roles autorizados:** Administrador.

La Plataforma le brinda al Administrador el servicio de Reportes de funcionalidades. En este puede ver el reporte categorías, respuestas, necesidades u ofertas.

Para ver los resportes el Administrador debe desplegar la opción de reportes en el menú principal.

[![reportes.jpg](https://i.postimg.cc/PrkYnPpW/reportes.jpg)](https://postimg.cc/8stjhkbc)

## Reporte de necesidades

## Reporte de ofertas

## Reporte de respuestas

## Reporte de categorias

El servicio de reportes incluye la funcionalidad de descarga en .pdf y .xsml. Para esto el administrador debe oprimir el botón correspondiente al formato que prefiere y ya tendrá el reporte correspondiente descargado.

## Arquitectura y Diseño detallado

## Modelo E-R

[![modelo-ER.jpg](https://i.postimg.cc/pyN21RzW/modelo-ER.jpg)](https://postimg.cc/RJR5Wrgy)

## Diagrama de clases

<img src="imagenes/Class Diagram.jpg">

### Descripción de la arquitectura y del Stack de tecnologías utilizado

## Capas

+ Aplicación
+ Presentación
+ Persistencia

**Capa de aplicación:** En la capa de aplicación se utilizarón las siguientes tecnologías:

+ Java : Java es una tecnología empleada para el desarrollo de aplicaciones que convierten a la Web en un elemento más interesante y útil. Empleamos este lenguaje de programación para el desarrollo de la plataforma SOLIDARIDAD ECI.

+ Google Guice : Google Guice es un framework que permite la inyección de dependencias.

+ Maven : Maven es una herramienta de software para la gestión y construcción de proyectos. Este fue empleado para la construcción y administración de nuestro proyecto de inicio a fin.

+ Apashe Shiro: Apashe Shiro permite el control de autenticación en aplicaciones. Este fue implementado para el control de autorizaciones y accesos. 

+ JaCoCo: JaCoCo es una herramienta para Java que evalua la cobertura de pruebas. Esta herramienta fue usada para el analisis del cubriento de las pruebas realizadas y la generación del reporte de estas.

**Capa de presentación:**

+ JFS: Java Server Faces es un framework de interfaz de usuario para aplicaciones web en Java. Este fue empleado para la construcción de las interfaces de usuario y su en lace con los beans en la capa de aplicación.

+ Primefaces: Primefaces es una biblioteca de componentes de JSF que brinda diferentes elementos visuales. Fue empleada para el desarrollo de las diferentes pantallas de usuario.

+ CSS: CSS es un lenguaje que permite dar estilo a los archivos html. CSS fue empleado para dar estilo y posicionar visualmente las diferentes interfaces. 

**Capa de persistencia:** 

+ PostgreSQL: Postgrest es un sistema gestor de bases de datos relacionales. Fue usado para la persistencia de la información correspondiente al proyecto.

+ MyBatis: MyBatis es una herramienta de persistencia Java. Este fue empleado para el mapeo de las sentencias SQL.

## Descripción del proceso

### Breve descripción de la Metodología

Para el desarrollo de este proyecto empleamos la metodología SCRUM. Mediante **Taiga** se llevo la administración del proyecto, se manejo el proceso de cada uno de los Sprints y las Historias de Usuario correspondientes, de igual manera se asignaron las tareas a cada usuario según el rol asignado.  

### Release-burndown chart

<img src="imagenes/scrum_total.png">

# Sprints

## Sprint 1

Para este primer Sprint definimos 3 historias de usuario: Iniciar sesión, Crear Categoría y Actualizar Categoría. Tuvimos inconvenientes en la implementación y pruebas de Apashe Shiro lo cual era indispensable para lograr satisfactoriamente el inicio de sesión lo que nos impidió terminar a tiempo el Sprint. Sin embargo, se cumplió con la realización correcta de las historias de usuario establecidas.

<img src="imagenes/sprint1.png">

Historias de usuario:

<img src="imagenes/sprint1_hu.png">

## Sprint 2

Para el segundo Sprint definimos 6 historias de usuario: Registrar Necesidad, Registrar Oferta, Registrar Respuesta, Actualizar estado Necesidad, Actualizar estado Oferta y Reporte de necesidades. En este Sprint tuvimos inconvenientes con la base de datos y lo correspondiente a los mapeos lo que nos impidió terminar a tiempo el Sprint, sin embargo se cumplió con la totalidad de las historias de usuario. 

<img src="imagenes/sprint2.png">

Historias de usuario:

<img src="imagenes/sprint2_hu.png">

## Sprint 3

Para el tercer y último Sprint definimos 5 historias de usuario: Reporte de ofertas, Reporte de respuestas, Reporte de Categorías más solicitadas/ofrecidas, Eliminar categoria y Gestión de categorías no validas. En este último Sprint tuvimos problemas con lo relacionado a los reportes pero se cumplió totalmente con el Sprint y nos permitió la culminación del proyecto.

<img src="imagenes/sprint3.png">

Historias de usuario:

<img src="imagenes/sprint3_hu.png">

### Reporte de pruebas y de cubrimiento de las mismas 