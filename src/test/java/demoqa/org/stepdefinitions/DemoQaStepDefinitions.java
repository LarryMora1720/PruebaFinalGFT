package demoqa.org.stepdefinitions;

import demoqa.org.page.PaginaPrincipal;
import demoqa.org.page.PrimerFormulario;
import demoqa.org.page.SegundoFormulario;
import demoqa.org.page.TercerFormulario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class DemoQaStepDefinitions {
    @Managed
    WebDriver driver;

    public PaginaPrincipal paginaPrincipal;
    public PrimerFormulario primerFormulario;
    public SegundoFormulario segundoFormulario;
    public TercerFormulario tercerFormulario;

    @Given("que ingreso a la pagina de utest")
    public void queingresoalapaginadeutest() {
        paginaPrincipal.openUrlPrueba("https://www.utest.com/");
        paginaPrincipal.clickBotonJoinNow();
    }


    @When("completo el formulario {string} {string} {string}")
    public void completoElFormulario (String nombre, String apellido, String correo) {
        primerFormulario.sendkeyPrimerNombre(nombre);
        primerFormulario.sendkeyApellido(apellido);
        primerFormulario.sendkeycorreo(correo);
        primerFormulario.sendkeymesNacimiento();
        primerFormulario.sendkeydiaNacimiento();
        primerFormulario.sendkeyañoNacimiento();
        primerFormulario.clickBotonNextLocationYValidarPagina();
    }

    @Then("ingreso al segundo paso y completo el formulario {string} {string} {string} y Country")
    public void ingresoalsegundopasoycompletoelformularioyCountry(String textoBusqueda, String opcionDeseada, String postalCode) throws InterruptedException {
        segundoFormulario.clickBotonLimpiar();
        segundoFormulario.sendkeyCiudad(textoBusqueda, opcionDeseada);
        segundoFormulario.sendkeyPostalCode(postalCode);
        segundoFormulario.sendkeyCountry();
        segundoFormulario.clickBotonNextDivices();
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
        tercerFormulario.listaSistemaOperativo();
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