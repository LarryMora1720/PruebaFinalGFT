Feature: Yo como usuario quiero crear una Automatización que se encargue de ingresar a la página realizar el diligenciamiento de los
  formularios con la finalidad de crear un nuevo usuario.

  @RegisterDemoQA
  Scenario: registro Utest
    Given que ingreso a la pagina de utest
    When completo el formulario "Larry" "Mora" "ext_lmmorac@falabella.cl"
    Then ingreso al segundo paso del registro limpio el campo City
    ##And doy click en el boton next Location


