package demoqa.org.stepdefinitions;

import demoqa.org.page.*;
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
    public UltimoFormulario ultimoFormulario;

    @Given("que ingreso a la pagina de utest")
    public void queingresoalapaginadeutest() {
        paginaPrincipal.openUrlPrueba("https://www.utest.com/");
        paginaPrincipal.clickBotonJoinNow();
    }


    @When("completo el formulario {string} {string} {string}")
    public void completoElFormulario(String nombre, String apellido, String correo) {
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

    @And("ingreso al tercer paso y completo informacion de los dispositivos")
    public void ingresoaltercerpasoycompletoinformaciondelosdispositivos() {
        tercerFormulario.listaSistemaOperativoPc();
        tercerFormulario.listaVersion();
        tercerFormulario.clickLanguage();
        tercerFormulario.clickUMobileDivice();
        tercerFormulario.clickModel();
        tercerFormulario.clicksystem();
    }

    @And("creo la nueva {string} para finalizar con el registro en Utest")
    public void creolanuevacontraseñaparafinalizarconelregistroenUtest(String contraseña) {
        ultimoFormulario.finalizacionRegistro(contraseña);
        ultimoFormulario.registroOk();
    }


}