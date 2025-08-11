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
    }
    @When("doy click en el boton join now")
    public void doyclickenelbotonjoinnow() {
        demoQaPage.clickBotonJoinNow();
    }

    @Then("completo el formulario {string} {string} {string}")
    public void completoElFormulario(String nombre, String apellido, String correo) {
        demoQaPage.sendkeyPrimerNombre(nombre);
        demoQaPage.sendkeyApellido(apellido);
        demoQaPage.sendkeycorreo(correo);
        demoQaPage.sendkeymesNacimiento();
        demoQaPage.sendkeydiaNacimiento();
        demoQaPage.sendkeyañoNacimiento();
    }


    @And("doy click en el boton next Location")
    public void doyclickenelbotonnextLocation() {
       demoQaPage.clickBotonNextLocation();
    }
}
