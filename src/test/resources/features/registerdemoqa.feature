Feature: Yo como usuario quiero crear una Automatización que se encargue de ingresar a la página realizar el diligenciamiento de los
  formularios con la finalidad de crear un nuevo usuario.

  @RegisterDemoQA
  Scenario: Registro de nuevo usuario en la pagina Utest
    Given que ingreso a la pagina de utest
    When completo el formulario "Larry" "Mora" "ext_lmmoracc@falabella.cl"
    Then ingreso al segundo paso y completo el formulario "Bogotá" "Bogotá, Bogota, Colombia" "99999" y Country
    And ingreso al tercer paso y completo informacion de los dispositivos
    And creo la nueva "PruebaTest@1234.*" para finalizar con el registro en Utest
