package demoqa.org.stepdefinitions;

import demoqa.org.page.DemoQaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class DemoQaStepDefinitions {
    @Managed
    WebDriver driver;

    public DemoQaPage demoQaPage;

    @Given("que ingreso a la pagina de utest")
    public void queingresoalapaginadeutest() {
        demoQaPage.openUrlPrueba("https://www.utest.com/");
        demoQaPage.clickBotonJoinNow();
    }

    @When("completo el formulario {string} {string} {string}")
    public void completoElFormulario (String nombre, String apellido, String correo) {
        demoQaPage.sendkeyPrimerNombre(nombre);
        demoQaPage.sendkeyApellido(apellido);
        demoQaPage.sendkeycorreo(correo);
        demoQaPage.sendkeymesNacimiento();
        demoQaPage.sendkeydiaNacimiento();
        demoQaPage.sendkeyañoNacimiento();
        demoQaPage.clickBotonNextLocationYValidarPagina();
    }

    @Then("ingreso al segundo paso y completo el formulario {string} {string} {string} y Country")
    public void ingresoalsegundopasoycompletoelformularioyCountry(String textoBusqueda, String opcionDeseada, String postalCode) {
        demoQaPage.clickBotonLimpiar();
        demoQaPage.sendkeyCiudad(textoBusqueda, opcionDeseada);
        demoQaPage.sendkeyPostalCode(postalCode);
        demoQaPage.sendkeyCountry();
        demoQaPage.clickBotonNextDivices();
    }
    /*
        @Then("ingreso al segundo paso y completo el formulario {string} {string} {string} {string} y Country")
        public void ingresoalsegundopasoycompletoelformularioyCountry(String textoBusqueda, String opcionDeseada, String postalCode,String valorBusqueda) {
            demoQaPage.clickBotonLimpiar();
            demoQaPage.sendkeyCiudad(textoBusqueda, opcionDeseada);
            demoQaPage.sendkeyPostalCode(postalCode);
            demoQaPage.sendkeyCountry();
            demoQaPage.clickBotonNextDivices();
            demoQaPage.listaSistemaOperativo();
            demoQaPage.clickEligeSistemaOperativo(valorBusqueda);


    */
    @And("ingreso al tercer paso y completo informacion de los dispositivos")
    public void ingresoaltercerpasoycompletoinformaciondelosdispositivos() {
        demoQaPage.listaSistemaOperativo();
    }

/*
    //public DemoQaPage demoQaPage2;

    @And("que ingreso al segundo paso del registro limpio el campo City")
    public void queingresoalsegundopasodelregistrolimpioelcampoCity() {
        demoQaPage.clickBotonLimpiar();
    }

    @And("completo los campos {string} {string} y Contry")
    public void completoloscamposCityPostalCodeyCountry(String City, String postalCode) {
        demoQaPage.sendkeyCiudad(City);
        demoQaPage.sendkeyPostalCode(postalCode);
        demoQaPage.sendkeyCountry();
    }

    @And("doy click en el boton next Divices")
    public void doyclickenelbotonnextDivices() {
        demoQaPage.clickBotonNextDivices();

    }

*/

}