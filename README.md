#  Proyecto de Automatización Web: Registro de Usuario en uTest

Este proyecto automatiza el proceso de registro de un nuevo usuario en el portal [uTest](https://www.utest.com/) utilizando **Serenity BDD**, **Cucumber** y **Selenium WebDriver**.

---

##  Objetivo

Automatizar el proceso completo de creación de un nuevo usuario en uTest, incluyendo el diligenciamiento de los formularios paso a paso:

1. Datos personales
2. Dirección
3. Dispositivos
4. Seguridad y finalización

---

##  Arquitectura del Proyecto

Este proyecto está basado en el patrón **Page Object Model (POM)**. La lógica de automatización está dividida en varias capas:

- `PaginaPrincipal.java`: Interacción inicial con la página y acceso al formulario.
- `PrimerFormulario.java`: Captura de datos personales como nombre, apellido, correo, y fecha de nacimiento.
- `SegundoFormulario.java`: Captura de dirección: ciudad, país y código postal.
- `TercerFormulario.java`: Captura de información sobre los dispositivos del usuario.
- `UltimoFormulario.java`: Registro de contraseña, aceptación de términos y finalización del proceso.

---

##  Escenario de prueba (`.feature`)

```gherkin
Feature: Registro de nuevo usuario en uTest

  @RegisterDemoQA
  Scenario: Registro de nuevo usuario en la página Utest
    Given que ingreso a la pagina de utest
    When completo el formulario "Larry" "Mora" "ext_lmmorac@fallabellla.cl"
    Then ingreso al segundo paso y completo el formulario "Bogotá" "Bogotá, Bogota, Colombia" "99999" y Country
    And ingreso al tercer paso y completo informacion de los dispositivos
    And creo la nueva "PruebaTest@1234.*" para finalizar con el registro en Utest
